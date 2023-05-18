package main;

import java.util.ArrayList;
import java.util.Collection;

public class Solution implements NumberRangeSummarizer{

    // collect the input
    public Collection<Integer> collect(String input){
        Collection<Integer> listOfIntegers = new ArrayList<Integer>();
        for (String s : input.split(","))
            listOfIntegers.add(Integer.parseInt(s));
        return listOfIntegers;
    }

    // get the summarized string
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
