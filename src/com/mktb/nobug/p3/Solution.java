package com.mktb.nobug.p3;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> chMap = new HashMap<>();

        int max = 0;
        int nowmax = 0;

        for (int i = 0; i < s.length();) {
            if (!chMap.containsKey(s.charAt(i))) {
                chMap.put(s.charAt(i), i);
                nowmax++;
                i++;
            } else {
                if (nowmax > max) {
                    max = nowmax;
                }
                nowmax = 0;
                i = chMap.get(s.charAt(i)) + 1;
                chMap.clear();
            }
        }

        if (nowmax > max) {
            max = nowmax;
        }

        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> chMap = new HashMap<>();

        int max = 0;
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (chMap.containsKey(s.charAt(i))) {
                j = Math.max(chMap.get(s.charAt(i)) + 1, j);
            }
            max = Math.max(max, i - j + 1);
            chMap.put(s.charAt(i), i);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring1("abba"));
    }
}
