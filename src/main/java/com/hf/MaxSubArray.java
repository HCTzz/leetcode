package com.hf;

/**
 * @Description
 * @auther Administrator
 * @create 2020-02-21 下午 12:43
 */
public class MaxSubArray {

    public int crossSum(int[] nums, int left, int right, int p) {
        if (left == right) {
            return nums[left];
        }

        int leftSubsum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = p; i > left - 1; --i) {
            currSum += nums[i];
            leftSubsum = Math.max(leftSubsum, currSum);
        }

        int rightSubsum = Integer.MIN_VALUE;
        currSum = 0;
        for(int i = p + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubsum = Math.max(rightSubsum, currSum);
        }

        return leftSubsum + rightSubsum;
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int p = (left + right) / 2;

        int leftSum = helper(nums, left, p);
        int rightSum = helper(nums, p + 1, right);
        int crossSum = crossSum(nums, left, right, p);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }


    public int maxSubArray1(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    public static int lengthOfLastWord(String s) {
        if(s == null || "".equals(s.trim())){
            return 0;
        }
        char space = ' ';
        char[] chars = s.toCharArray();
        StringBuffer sf = new StringBuffer();
        for(int i = chars.length - 1;i >=0 ; i--){
            if(space == chars[i] ){
                if(sf.length() > 0){
                    break;
                }
            }else{
                sf.append(chars[i]);
            }
        }
        return sf.length();
    }

    public static void main(String[] args) {
        String s = "Hello World ";
        System.out.println(lengthOfLastWord(s));
    }
}
