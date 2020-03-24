package com.hf;

/**二叉树的最大深度
 * @Description
 * @auther Administrator
 * @create 2020-02-25 下午 3:08
 */
public class MaxDepth {

    private static int i = 0;

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }
}
