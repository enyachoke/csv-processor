package com.emmanuelnyachoke.csvprocessor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class CSVReaderTest {
    @Test
    public void mapCSVTest()  {
        String separator = ",";
        CSVReader<SampleScore> reader = new CSVReader<>(SampleScore.class);
        File file = new File("src/test/resources/testMapping.csv");
        String absolutePath = file.getAbsolutePath();
        List<SampleScore> scores = reader.readListFromCSV(absolutePath);
        assertThat(scores.get(0).getTestDate(), instanceOf(Date.class));
        assertThat(scores.get(0).getStudentName(), instanceOf(String.class));
    }

    @Test public void testSplit() {
        String[] expectedOutput = {"test", "test"};
        assertArrayEquals(expectedOutput, CSVParser.CSVSplit("test,test"));
    }

    @Test
    public void TestWriteCSV() throws IOException {
        String separator = ",";
        CSVReader<SampleScore> reader = new CSVReader<>(SampleScore.class);
        List<SampleScore> testScores = new ArrayList<>();
        SampleScore sampleScore1 = new SampleScore();
        sampleScore1.setStudentName("Emmanu");
        sampleScore1.setTestDate(new Date());
        sampleScore1.setTotalScore(90);
        sampleScore1.setPassed(true);

        SampleScore sampleScore2 = new SampleScore();
        sampleScore2.setStudentName("DD");
        sampleScore2.setTestDate(new Date());
        sampleScore2.setTotalScore(90);
        sampleScore2.setPassed(true);


        SampleScore sampleScore3 = new SampleScore();
        sampleScore3.setStudentName("Deby");
        sampleScore3.setTestDate(new Date());
        sampleScore3.setTotalScore(90);
        sampleScore3.setPassed(true);

        testScores.add(sampleScore1);
        testScores.add(sampleScore2);
        testScores.add(sampleScore3);


        File file = new File("src/test/resources/testCSV.csv");
        String absolutePath = file.getAbsolutePath();
        reader.writeCSV(file,testScores);

        List<SampleScore> scores =
                reader.readListFromCSV(absolutePath);
        assertEquals(3,scores.size());

    }




}
