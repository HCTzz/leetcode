package com.hf;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀
 * @auther Administrator
 * @create 2020-02-07 下午 2:16
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs){
        Arrays.sort(strs);
        Arrays.stream(strs).forEach(System.out::println);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for(Character c : str1.toCharArray()){
            if(c.equals(str2.charAt(i++))){
                sb.append(c);
            }else{
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] str = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(str));
    }
}
