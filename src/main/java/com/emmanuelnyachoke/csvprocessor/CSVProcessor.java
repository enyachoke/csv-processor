package com.emmanuelnyachoke.csvprocessor;


import java.io.*;
import java.util.List;


public class CSVProcessor<T> {
    public static void main(String[] args) throws Exception {
        File inputFile = null;
        String separator = "";

        if (args.length > 0) {
            inputFile = new File(args[0]);

            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            if(args.length >= 2){
                separator = args[1];
            }
//            CSVtoObjectMapper<SampleScore> scoresMapper = new CSVtoObjectMapper<>(SampleScore.class);
//            List<SampleScore> scores = scoresMapper.mapCSV(bufferedReader, separator);
//            System.out.println(scores.get(0).getStudentName());
            // File csvFile = new File("test.csv");
            // scoresMapper.writeCSV(csvFile,scores,true,",");
            CSVReader<SampleScore> reader = new CSVReader<>(SampleScore.class);
            List<SampleScore> scores =
                    reader.readListFromCSV(args[0]);
            File csvFile = new File("test.csv");
            reader.writeCSV(csvFile,scores);

            System.out.println(scores.size());
            System.out.println(scores.get(0).getStudentName());
            System.out.println(scores.get(0).getTestDate());
            System.exit(0);
        } else {
            System.err.println("Invalid arguments count:" + args.length);
            System.exit(1);
        }




    }


    }
