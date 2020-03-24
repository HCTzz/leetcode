package com.hf;

/**
 * 移除元素
 * @auther Administrator
 * @create 2020-02-09 下午 1:48
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len < 1){
            return 0;
        }
//        int i = 0;
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] != val) {
//                nums[i] = nums[j];
//                i++;
//            }
//        }
        int i = 0;
        int n = len;
        while (i < n){
            if(nums[i] == val){
                nums[i] = nums[n - 1];
                n --;
            }else{
                i ++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int c = removeElement(nums, 2);
        System.out.println(c);
        for (int i =0 ;i < c;i++){
            System.out.println(nums[i]);
        }

    }

}
