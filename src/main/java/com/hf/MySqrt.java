package com.hf;

/**
 * @Description
 * @auther Administrator
 * @create 2020-02-24 上午 8:48
 */
public class MySqrt {

    //算法一：袖珍计算器算法
    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }
        int left = (int)Math.pow(Math.E,0.5 * Math.log(x));
        int right = left + 1;
        return (long)right * right > x ? left :right;
    }

    //算法二：二分法
    public static int mySqrt1(int x){
        if(x < 2){
            return x;
        }
        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num > x) {
                right = pivot - 1;
            } else if (num < x) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }
        return right;
    }

    //算法三：牛顿法   Xn+1 = 0.5 * {Xn + X/Xn}
    public static int mySqrt2(int x){
        if (x < 2) {
            return x;
        }
        double x0 = x;
        double x1 = (x0 + x / x0) / 2.0;
        while (Math.abs(x0 - x1) >= 1) {
            x0 = x1;
            x1 = (x0 + x / x0) / 2.0;
        }
        return (int)x1;
    }

    public static void main(String[] args) {
        mySqrt2(3);
    }
}
