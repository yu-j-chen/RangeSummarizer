package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Yu-Ju Chen
 */
public class Main {
    public static void main(String[] args) {

        //        Solution solution = new Solution();
        //        String output = solution.summarizeCollection(solution.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31"));
        //        System.out.println(output);

        NumberRangeSummarizer solution = new Solution();
        String inputData = readInputFile("src/main/input.txt");
        String output = solution.summarizeCollection(solution.collect(inputData));
        System.out.println("Result: " + output);
    }

    public static String readInputFile(String fileName) {
        String inputData = "";
        try {
            Scanner reader = new Scanner(new File(fileName));
            while (reader.hasNextLine()) {
                inputData += reader.nextLine();
                if (reader.hasNextLine()) {
                    inputData += ",";
                }
            }
            System.out.println("Sample Input: " + inputData);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unsuccessful read from textfile");
            e.printStackTrace();
        }
        return inputData;
    }
}