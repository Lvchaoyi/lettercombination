package solution;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private Integer[] digits;
    private List<String> res;
    private StringBuilder str;
    private String[] numbers;

    Solution() {
        this.numbers = new String[]{"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    }

    Solution(String[] numbers) {
        this.numbers = numbers;
    }


    public List<String> letterCombinations(Integer[] digits) {
        //backtracking

        StringBuilder sb = new StringBuilder();
        for (Integer i: digits) {
            sb.append(i);
        }
        String[] strDigits = sb.toString().split("");

        this.digits = new Integer[strDigits.length];
        for (int i=0;i<strDigits.length;i++) {
            this.digits[i] = Integer.valueOf(strDigits[i]);
        }
        res = new ArrayList<>();
        if(digits.length == 0) {
            return res;
        }
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
        Integer[] i = {1, 23, 4};
        List<String> result = s.letterCombinations(i);
        System.out.println(result);
    }
}
