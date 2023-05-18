package test;

import main.NumberRangeSummarizer;
import main.Solution;
import org.junit.jupiter.api.Test;
import java.util.Collection;

public class SolutionTest {

    private String inputString = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";


    /**
     * Unit test: method collectInput() returns collection of integers
     */
    @Test
    public void collectInputReturnsNotNull() {
        NumberRangeSummarizer solution = new Solution();
        Collection<Integer> inputs = solution.collect(inputString);
        assert !inputs.isEmpty(): "Input string was not collected.";
    }


    /**
     * Unit test: method collectInput() returns collection of integers in identical order of appearance in input string
     */
    @Test
    public void collectInputReturnsExpectedOutput() {
        NumberRangeSummarizer solution = new Solution();
        Collection<Integer> inputs = solution.collect(inputString);
        int[] list = inputs.stream().mapToInt(Integer::intValue).toArray();

        int i = 0;
        for (String s : inputString.split(",")) {
            assert Integer.parseInt(s) == list[i] : "Input string was not correctly collected and formatted.";
            i++;
        }
    }

    /**
     * Unit test: method summarizeCollection() returns non-empty string
     */
    @Test
    public void summarizeCollectionReturnsNotNull() {
        NumberRangeSummarizer solution = new Solution();
        Collection<Integer> inputs = solution.collect(inputString);
        String obtainedOutput = solution.summarizeCollection(inputs);
        assert !obtainedOutput.equals("") : "Empty string returned.";
    }

    /**
     * Unit test: method summarizeCollection() returns string as expected output
     */
    @Test
    public void summarizeCollectionReturnsExpectedOutput() {
        NumberRangeSummarizer solution = new Solution();
        Collection<Integer> inputs = solution.collect(inputString);
        String obtainedOutput = solution.summarizeCollection(inputs);
        String expectedOutput = "1, 3, 6-8, 12-15, 21-24, 31";
        int isTrue = obtainedOutput.compareTo(expectedOutput);
        assert isTrue == 0: "Input string was not correctly grouping sequential numbers into ranges.";
    }
}
