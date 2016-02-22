//Insert a node in a sorted linked list.

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The head of linked list.
     * @param val: an integer
     * @return: The head of new linked list
     */
    public ListNode insertNode(ListNode head, int val) { 
        ListNode node = new ListNode(val);
        ListNode cur = head;
        //1)head is null 2)head.val > node.val 3)node is in the middle
        if (head == null) {
            head = node;
        }   else if (head.val > val) {
            node.next = head;
            head = node;
        }
        else {
        while (cur.next != null && cur.next.val <= val) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        }
        return head;
    }  
}

public class Solution {
    /**
     * @param head: The head of linked list.
     * @param val: an integer
     * @return: The head of new linked list
     */
    public ListNode insertNode(ListNode head, int val) { 
        ListNode node = new ListNode(val);
        ListNode dummy = new ListNode(0);
        //nine chapter: use a dummy before head, so that without considering when head.val > node.val
        dummy.next = head;
        head = dummy;
        
        // find the last element <= val
        while (head.next != null && head.next.val <= val) {
            head = head.next;
        }
        node.next = head.next;
        head.next = node;
        
        return dummy.next;
    }  
}