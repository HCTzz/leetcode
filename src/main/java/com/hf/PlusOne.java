package com.hf;

/**
 * @Description
 * @auther Administrator
 * @create 2020-02-23 下午 8:56
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits.length == 1){
            int i = digits[0];
            return i == 9 ? new int[]{1, 0} : new int[]{i + 1};
        }
        int k = 1;
        for (int i = digits.length - 1;i >= 0;i--){
            if(digits[i] == 9 && k == 1){
                digits[i] = 0;
                k = 1;
            }else{
                digits[i] += k;
                k = 0;
            }
        }
        if(k == 1){
            int[] rt = new int[digits.length + 1];
            rt[0] = 1;
            for (int i = 0;i < digits.length;i++){
                rt[i + 1] = digits[i];
            }
            return rt;
        }else{
            return digits;
        }
    }


    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }



}
