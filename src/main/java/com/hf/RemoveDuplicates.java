package com.hf;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description
 * @auther Administrator
 * @create 2020-02-09 上午 11:09
 */
public class RemoveDuplicates {

    public static int[] removeDuplicates(int[] nums){
        if(nums == null){
            return null;
        }
        Stack<Integer> st = new Stack();
        st.push(nums[0]);
        int cout = 1;
        for(int i = 1;i< nums.length;i++){
           int num = st.peek();
           if(num != nums[i]){
               st.push(nums[i]);
               cout ++;
           }
        }
        int[] rtArr = new int[cout];
//        while (!st.isEmpty()){
//            rtArr[--cout] = st.pop();
//        }
        while (!st.isEmpty()){
            nums[--cout] = st.pop();
        }
        return rtArr;
    }

    public static void main(String[] args) {
        int[] test = {1,1,2};
        removeDuplicates(test);
        Arrays.stream(test).forEach(System.out::println);
//        Arrays.stream(removeDuplicates(test)).forEach(i -> {
//            System.out.println(i);
//        });
    }
}
