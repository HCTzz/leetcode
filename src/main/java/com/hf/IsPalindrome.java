package com.hf;

import java.util.Stack;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @auther Administrator
 * @create 2020-02-06 下午 9:43
 */
public class IsPalindrome {

    //官方方法
    public boolean IsPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) { //x =4321   x=432 r = 1   x=43 r= 12 x=4 r=123
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }
        if(x > 10){
            String tmp = String.valueOf(x) ;
            int tempL = tmp.length();
            String tmp2 = tmp.substring(0,tempL / 2);
            String tmp1 = tmp.substring(tempL / 2 , tempL);
            if(tempL % 2 != 0){
                tmp1 = tmp.substring(tempL / 2 + 1 , tempL);
            }
            int r = IntegerReverse.reverse(Integer.valueOf(tmp2));
            if(r == Integer.valueOf(tmp1)){
                return true;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
//        String patt="[^0-9|a-z|A-Z]";
//        Pattern r = Pattern.compile(patt);
//        Matcher matcher = r.matcher(str);
//        return matcher.find();
//        s = s.replaceAll("[^0-9|a-z|A-Z]","");
        System.out.println(isPalindrome(s));
//        System.out.println(isPalindrome(12321));
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^0-9|a-z|A-Z]","").toLowerCase();
        int len = s.length();
        if(len == 0 || len == 1){
            return true;
        }
        for (int i = 0; i < len / 2; i++) {
            if(s.charAt(i) != s.charAt(len - i - 1)){
                return false;
            }
        }
        return true;
    }


}
