package com.mktb.nobug.p5;

public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        String ans = "";
        boolean[][] dp = new boolean[length][length];

        for (int len = 0; len < length; len++) {
            for (int i = 0; i + len < length; i++) {
                int j = i + len;
                if (len == 0) {
                    dp[i][j] = true;
                } else if (len == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }

                if (dp[i][j] && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }

        return ans;
    }
}
