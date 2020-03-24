package com.hf;

/**相同的树
 * @Description
 * @auther Administrator
 * @create 2020-02-25 上午 11:52
 */
public class IsSameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


}
