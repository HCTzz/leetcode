package com.hf;

/**
 * @Description
 * @auther Administrator
 * @create 2020-02-11 上午 10:39
 */
public class 二分查找模版 {

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1; // 注意
            while(left <= right) { // 注意
                int mid = (left + right) / 2; // 注意
                if(nums[mid] == target) { // 注意
                    // 相关逻辑
                } else if(nums[mid] < target) {
                    left = mid + 1; // 注意
                } else {
                    right = mid - 1; // 注意
                }
            }
            // 相关返回值
            return 0;
        }
    }
}
