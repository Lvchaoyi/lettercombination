package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();

        Integer[] digits;

        digits = new Integer[]{0};
        Test.Check(solution.letterCombinations(digits), new ArrayList<String>());

        digits = new Integer[]{0, 1, 1, 1};
        Test.Check(solution.letterCombinations(digits), new ArrayList<String>());

        digits = new Integer[]{9};
        Test.Check(solution.letterCombinations(digits), Arrays.asList("W", "X", "Y", "Z"));

        digits = new Integer[]{1, 0, 1, 2};
        Test.Check(solution.letterCombinations(digits), Arrays.asList("A", "B", "C"));

    }

    public static void Check(List<String> src, List<String> match) throws Exception {
        if(src.size() != match.size() || !src.containsAll(match)){
            System.out.println(src);
            System.out.println(match);
            throw new Exception("Check fail");
        } else {
            System.out.println("Check successfully");
        }
    }

}