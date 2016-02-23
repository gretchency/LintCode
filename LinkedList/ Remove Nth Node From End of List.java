//Given a linked list, remove the nth node from the end of list and return its head.

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // 用两个node
        // 一个先走n步，然后第二个开始走
        // 当第一个走到null时，第二个就在倒数第n点了
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode deleteNode = dummy;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            deleteNode = deleteNode.next;
        } 
        
        deleteNode.next = deleteNode.next.next;
        return dummy.next;
    }
}
