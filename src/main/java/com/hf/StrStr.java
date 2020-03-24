package com.hf;

import com.sun.istack.internal.NotNull;

/**
 * @Description
 * @auther Administrator
 * @create 2020-02-09 下午 7:37
 */
public class StrStr {

    public static int strStr(@NotNull String haystack,@NotNull String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
        if(needle.equals(haystack) ||"".equals(needle)){
            return 0;
        }
        char[] needs = needle.toCharArray();
        char[] chars = haystack.toCharArray();
        for(int j = 0;j<chars.length;j++){
            int i = 0;
            if(needs[0] == chars[j]){
                for(int k = 0;k < needs.length;k++){
                    if(k + j >= chars.length){
                        return -1;
                    }
                    if(needs[k] != chars[k+j]){
                        break;
                    }else{
                        i++;
                    }
                    if(i == needs.length){
                        return j;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        String s = "hello";
//        String s1 = "ll";
        String s = "mississippi";
        String s1 = "issipi";
        System.out.println(strStr(s, s1));
    }

}
