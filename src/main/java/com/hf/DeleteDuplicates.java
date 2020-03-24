package com.hf;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**删除排序链表中的重复元素
 * @Description
 * @auther Administrator
 * @create 2020-02-25 上午 10:20
 */
public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head){
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n.next = n1;
        n1.next = n2;
        ListNode rt = deleteDuplicates(n);
        while (rt != null){
            System.out.println(rt.val);
            rt = rt.next;
        }
    }


}
