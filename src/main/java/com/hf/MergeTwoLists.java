package com.hf;

import java.io.Console;

/**
 * 合并两个有序链表
 * @auther Administrator
 * @create 2020-02-08 下午 7:59
 */
public class MergeTwoLists {

    static class ListNode{
        private ListNode next;
        private int value;
        public ListNode(int value){
            this.value = value;
            this.next = null;
        }

        public ListNode(ListNode node){
            this.value = node.value;
            this.next = null;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode prev = temp;
        while(l1 != null && l2 != null){
            if(l1.value > l2.value){
                prev.next = l2;
                l2 = l2.next;
            }else{
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        ListNode n1 = new ListNode(6);
        n.next = n1;
        ListNode n2 = new ListNode(8);
        n1.next = n2;
        ListNode n3 = new ListNode(10);
        n2.next = n3;
        ListNode n4 = new ListNode(11);
        n3.next = n4;


        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(4);
        n5.next = n6;
        ListNode n7 = new ListNode(5);
        n6.next = n7;
        ListNode n8 = new ListNode(8);
        n7.next = n8;
        ListNode n9 = new ListNode(9);
        n8.next = n9;
        ListNode n10 = new ListNode(10);
        n9.next = n10;
        ListNode rtNode = mergeTwoLists(n,n5);
        while (rtNode != null){
            System.out.println(rtNode.value);
            rtNode = rtNode.next;
        }
    }

}
