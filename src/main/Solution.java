package main;

import java.util.ArrayList;
import java.util.Collection;

public class Solution implements NumberRangeSummarizer{

    /**
     * Method takes as input a string, and formats it appropriately to the required data structure
     */
    public Collection<Integer> collect(String input){
        Collection<Integer> listOfIntegers = new ArrayList<Integer>();
        for (String s : input.split(","))
            listOfIntegers.add(Integer.parseInt(s));
        return listOfIntegers;
    }


    /**
     * Method takes as input a collection of integers, and produces a comma delimited list of numbers
     * whereby it groups the sequential numbers into a range
     */
    public String summarizeCollection(Collection<Integer> input){
        String finalOutput = "";

        int[] list = input.stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < list.length; i++) {

            if (i != 0)
                finalOutput += ", ";

            int startNumber = list[i];
            while (i < list.length-1 && list[i]+1 == list[i+1]) {
                i++;
            }

            finalOutput += startNumber;
            if (startNumber != list[i]) {
                finalOutput += "-" + list[i];
            }
        }
        return finalOutput;
    }
}
