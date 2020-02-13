package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private Integer[] digits;
    private List<String> res;
    private StringBuilder str;
    private String[] numbers;

    public List<String> letterCombinations(Integer[] digits) {
        //backtracking
        this.digits = digits;
        res = new ArrayList<>();
        if(digits.length == 0) {
            return res;
        }
        numbers = new String[]{"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        str = new StringBuilder();
        dfs(0);

        return res;
    }

    private void dfs(int curLen) {
        if(curLen == digits.length) {
            if (str.length() != 0) {
                res.add(str.toString());
            }
            return;
        }
        char[] letters = numbers[digits[curLen]].toCharArray();
        if (letters.length == 0) {
            dfs(curLen + 1);
        } else {
            for(char ch: letters) {
                str.append(ch);
                dfs(curLen + 1);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Integer[] i = {1, 0, 1, 2};
        List<String> result = s.letterCombinations(i);
        System.out.println(result);
    }
}
