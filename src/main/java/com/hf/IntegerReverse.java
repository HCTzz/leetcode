package com.hf;

/**
 * @Description
 * @auther Administrator
 * @create 2020-02-06 下午 9:18
 */
public class IntegerReverse {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(12343));
    }

    public static int reverse(int x){
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }

}
