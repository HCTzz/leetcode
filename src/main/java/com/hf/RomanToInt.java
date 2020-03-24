package com.hf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * @auther Administrator
 * @create 2020-02-07 下午 8:29
 */
public class RomanToInt {

    private static Map<String,Integer> map = new HashMap<String,Integer>(8);

    static{
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
    }

    public static int romanToInt(String str){
        System.out.println(map);
        char[] cs = str.toCharArray();
        int[] tmps = new int[cs.length];
        int i = 0;
        for(Character c : cs){
            Integer tmp = map.get(c.toString());
            if(i > 0 && tmp > tmps[i - 1]){
                tmps[i - 1] = - tmps[i - 1];
            }
            tmps[i++] = tmp;
        }
        int count = Arrays.stream(tmps).sum();
        return count;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
