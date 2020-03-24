package com.hf;

import java.util.*;

/**
 * 最长回文串
 */
public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int i = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
        for (int k = 0; k < chars.length; k++) {
            map.put(chars[k],map.getOrDefault(chars[k],0)+1);
        }
        if(map.size() == 1){
            return map.get(chars[0]);
        }
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            int v = e.getValue();
            System.out.println(v);
            if(v % 2 == 0){
                i += v;
            }else if(j == 0){
                i += v;
                j = 1;
            }else{
                i += (v - 1);
            }
        }
        return i;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
//        longestPalindrome(s);
//        System.out.println(longestPalindrome(s));
        System.out.println(p(s));

    }


    public static int p(String s){
        int[] arr = new int[128];
        for(char c : s.toCharArray()) {
            arr[c]++;
        }
        int count = 0;
        for (int i : arr) {
            if(i > 0){
                System.out.println(i);
            }
            count += (i % 2);
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }

}
