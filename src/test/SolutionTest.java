package test;

import main.NumberRangeSummarizer;
import main.Solution;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class SolutionTest {

    private String inputString = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

    /**
     * Unit test to test workability and functionality of collecting string of inputs
     */
    @Test
    public void collectInputTest() {
        NumberRangeSummarizer solution = new Solution();
        Collection<Integer> inputs = solution.collect(inputString);
        int[] list = inputs.stream().mapToInt(Integer::intValue).toArray();

        int i = 0;
        for (String s : inputString.split(",")) {
            assert Integer.parseInt(s) == list[i] : "Input string was not correctly collected.";
            i++;
        }
    }

    /**
     * Unit test to test workability and functionality of grouping numbers into ranges when numbers are sequential
     */
    @Test
    public void summarizeCollectionTest() {
        NumberRangeSummarizer solution = new Solution();
        Collection<Integer> inputs = solution.collect(inputString);
        String output = solution.summarizeCollection(inputs);
        int isTrue = output.compareTo("1, 3, 6-8, 12-15, 21-24, 31");
        assert isTrue == 0: "Not correctly grouping numbers into range when numbers are sequential.";
    }
}
