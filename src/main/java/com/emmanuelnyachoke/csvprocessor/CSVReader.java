package com.emmanuelnyachoke.csvprocessor;

import com.emmanuelnyachoke.csvprocessor.annotations.CSVHeader;
import com.emmanuelnyachoke.csvprocessor.converters.ConverterUtils;
import com.emmanuelnyachoke.csvprocessor.interfaces.Converter;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class CSVReader<T> {

    private Class csvClass;
    private List<CSVInfo> fields;
    private Map converterMap =  ConverterUtils.converters();

    public CSVReader(Class csvClass) {
        this.csvClass = csvClass;
        fields = CSVInfo.getAnnotatedFieldInfo(csvClass);
    }

    public void writeCSV(File file, Collection<T> entities) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        try {
            if (csvClass.isAnnotationPresent(CSVHeader.class)) {
                CSVHeader header = (CSVHeader) csvClass.getAnnotation(CSVHeader.class);
                if (header.has_header()) {
                    bufferedWriter.write(buildHeader(fields));
                    bufferedWriter.newLine();
                }
            }
            for (T entity : entities) {

                addRow(bufferedWriter, entity);
                bufferedWriter.newLine();
            }
        } finally {
            bufferedWriter.flush();
        }
    }

    private String buildHeader(List<CSVInfo> fields ){
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for (CSVInfo csvInfo : fields) {
            if (first) {
                first = false;
            } else {
                sb.append(",");
            }
            sb.append(csvInfo.fieldName);
        }
        return sb.toString();

    }

    private void addRow(BufferedWriter bufferedWriter, T entity) throws IOException {
        String line = buildLine(entity);
        bufferedWriter.write(line);
    }

    public String buildLine(T entity) {
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for (CSVInfo columnInfo : fields) {
            try {
                Method getter = new PropertyDescriptor(columnInfo.field.getName(), entity.getClass()).getReadMethod();
                Object value = getter.invoke(entity);
                String formattedValue = null;
                Converter converter = (Converter) converterMap.get(columnInfo.getConverter());
                formattedValue = converter.javaToString(columnInfo,value);
                if (first) {
                    first = false;
                } else {
                    sb.append(",");
                }
                sb.append(formattedValue);
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private T getObjectFromCSV(String line, List<String> headerList) {
        List<String> fieldList = Arrays.asList(CSVParser.CSVSplit(line));
        if (headerList.size() != fieldList.size()) {
            System.out.println("Header list does not match field list");
            System.out.println(line);
            System.out.println("Ignoring line===");
            return null;
        }
        HashMap<String, String> headerToFieldMap = new HashMap<String, String>();
        for (int i = 0; i < headerList.size(); i++) {
            headerToFieldMap.put(headerList.get(i).trim(), fieldList.get(i).trim());
        }

        try {
            Object instance;
            try {
                instance = csvClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            }
            for (CSVInfo csvInfo : fields) {
                if (headerToFieldMap.keySet().contains(csvInfo.fieldName)) {
                    String fieldValue = headerToFieldMap.get(csvInfo.fieldName);
                    String trimmed = fieldValue.trim();
                    Converter converter = (Converter) converterMap.get(csvInfo.getConverter());

                    try {
                        csvInfo.field.set(instance, converter.stringToJava(csvInfo,trimmed));
                    }
                    catch (NumberFormatException nfe) {
                        nfe.printStackTrace();
                        System.out.println("Number Format exception");
                        System.out.println(line);
                        System.out.println("Ignoring line===");
                        return null;
                    }
                    catch (Exception pe) {
                        pe.printStackTrace();
                        System.out.println("Problem parsing data");
                        System.out.println(line);
                        System.out.println("Ignoring line ===");
                        return null;
                    }
                }

            }
            return (T) instance;
        } catch ( IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<T> readListFromCSV(String filename) {
        List<T> results = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            results = readListFromCSV(br);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return results;
    }

    private List<T> readListFromCSV(BufferedReader br) throws IOException{
        List<T> results = new ArrayList<>();
        List<String> headerList = new ArrayList<>();
        String input;
        if (csvClass.isAnnotationPresent(CSVHeader.class)) {
            CSVHeader header = (CSVHeader) csvClass.getAnnotation(CSVHeader.class);
            if (header.has_header()) {
                 headerList = Arrays.asList(CSVParser.CSVSplit(br.readLine()));
            }
        }
        while ((input = br.readLine()) != null) {
            T t = null;
            t = getObjectFromCSV(input,headerList);
            if (t != null) {
                results.add(t);
            }
        }

        return results;
    }





}
