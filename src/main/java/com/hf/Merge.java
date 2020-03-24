package com.hf;

import java.util.Arrays;

/**合并两个有序数组
 * @Description
 * @auther Administrator
 * @create 2020-02-25 上午 11:20
 */
public class Merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;//数组1下标指针
        int p2 = n - 1;//数组2小标指针
        int p = (m + n) - 1;
        while (p1 >= 0 && p2 >= 0){
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }
        if(p2 < 0){
            return ;
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }


    public static void main(String[] args) {
        int[] nums1 = {7,9,11,14,0,0,0};
        int[] nums2 = {2,4,6};
        merge(nums1,4,nums2,3);
        Arrays.stream(nums1).forEach(System.out::println);
    }
}
