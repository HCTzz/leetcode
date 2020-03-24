package com.hf;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * @auther Administrator
 * @create 2020-02-05 上午 10:19
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        System.out.println(map);
        return ans;
    }


    public static void main(String[] args) {
       int i = lengthOfLongestSubstring("jkfrl");
        System.out.println(i);
    }
}
