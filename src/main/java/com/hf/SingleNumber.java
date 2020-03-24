package com.hf;

import java.util.Arrays;

/**
 * @Description
 * @auther Administrator
 * @create 2020-03-13 上午 9:59
 */
public class SingleNumber {
    
    public static int singleNumber(int[] nums){
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] i = {4,1,2,1,2};
        System.out.println(singleNumber(i));
    }
}
