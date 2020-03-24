package com.hf;

/**
 * 搜索插入位置
 * @auther Administrator
 * @create 2020-02-11 上午 9:58
 */
public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len < 1){
            return -1;
        }
        int j = 0;
        if(nums[0] > target){
            return 0;
        }
        if(nums[len - 1] < target){
            return len;
        }
        for(int i = 0;i< len - 1;){
            if(nums[i] == target){
                j = i;
                break;
            }
            if(nums[i++] < target && nums[i] > target ){
                j = i;
                break;
            }
        }
        if(nums[len - 1] == target){
            j = len - 1;
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(searchInsert(nums, 3));
    }

}
