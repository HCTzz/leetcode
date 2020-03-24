package com.hf;

/**
 * @Description
 * @auther Administrator
 * @create 2020-02-25 上午 9:16
 */
public class ClimbStairs {

    public static int climbStairs(int x , int n){
        if(x > n){
            return 0;
        }
        if(x == n){
            return 1;
        }
        return climbStairs(x+1,n) + climbStairs(x + 2,n);
    }

    /**
     * @param x
     * @param n
     * @param nums
     * @return
     */
    public static int climbStairs1(int x,int n,int[] nums) {
        if (x > n) {
            return 0;
        }
        if (x == n) {
            nums[x] = 1;
            return 1;
        }
        if(nums[x] > 0){
            return nums[x];
        }
        nums[x] = climbStairs(x + 1, n) + climbStairs(x + 2, n);
        return nums[x];
    }

    //动态规划
    public static int climbStairs3(int x){
        if(x == 1){
            return x;
        }
        int[] nums = new int[x + 1];
        nums[1] = 1;
        nums[2] = 2;
        for(int i = 3;i <= x; i++){
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[x];
    }

    //斐波那契数
    public static int climbStairs4(int x){
        if(x == 1){
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= x; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    //斐波那契公式
    public int climbStairs(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs3(6));
    }




}
