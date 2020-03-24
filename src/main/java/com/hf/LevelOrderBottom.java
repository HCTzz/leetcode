package com.hf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @Description
 * @auther Administrator
 * @create 2020-02-25 下午 3:29
 */
public class LevelOrderBottom {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.addLast(null);
        LinkedList<Integer> tempList = null;
        while(!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if(node == null){
                if(tempList != null){
                    ((LinkedList<List<Integer>>) result).addFirst(tempList);
                    tempList = null;
                    queue.addLast(null);
                    continue;
                }
            } else {
                if(tempList == null){
                    tempList = new LinkedList<>();
                }
                tempList.addLast(node.val);
                if(node.left != null){
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    queue.addLast(node.right);
                }
            }
        }
        return result;
    }






}
