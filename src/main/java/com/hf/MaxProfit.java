package com.hf;

import java.util.*;

/**买卖股票的最佳时机
 * @Description
 * @auther Administrator
 * @create 2020-02-28 下午 4:15
 */
public class MaxProfit {

    //暴力法
    public static int maxProfit(int[] prices) {
        int k = 0;
        for (int i = prices.length - 1; i > 0 ; i--) {
            if(prices[i] < prices[i - 1]){
                continue;
            }
            for (int j = 0; j < i; j++) {
                if(prices[i] - prices[j] > k){
                    k = prices[i] - prices[j];
                }
            }
        }
        return k;
    }

    public static int maxProfit1(int[] prices) {
        if(prices == null){
            return 0;
        }
        int minprice = prices[0];
        int maxprofit = 0;
        for (int i = 1; i < prices.length ; i++) {
            if(prices[i] < minprice){
                minprice = prices[i];//1
            }else{
                maxprofit = prices[i] - minprice > maxprofit ?prices[i] - minprice : maxprofit;
            }
        }
        return maxprofit > 0 ? maxprofit : 0;
    }

    public static void main(String[] args) {
        int[] prices ={7,1,5,3,6,4};
        System.out.println(maxProfit1(prices));
    }

}
