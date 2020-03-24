package com.hf;


import sun.security.util.Length;

/**
 * @Description
 * @auther Administrator
 * @create 2020-02-25 下午 4:02
 */
public class SortedArrayToBST {

    int[] nums;

    public TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        // always choose left middle node as a root
        int p = (left + right) / 2;
        // inorder traversal: left -> node -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
    }

}
