//Reverse a linked list from position m to n.
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//  //把2～4之间的node给交换了 
//return 1->4->3->2->5->NULL.
//
//Note:
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list. 
//  这题最要紧的就是 在反转当中那段 mn后，成为了 1 n m end
//把 1-n和 m-end 连起来 是最关键的。 比方说 1->2->3->4->5 反转 2～4 成为 
// 1->4->3->2->5  那么 1->4的连接和2->5的连接 这些要搞好 所以就要记录
//第一段最后一个节点(第m-1个node)，反转段首节点(第m个node)，反转段首尾节点(标准反转做法return的newnode)，
//和最后段第一个节点(标准反转做法next.next)

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
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //Must use dummy as new head!
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        
        ListNode prev = head;
        //mNode is the tail of the reversed linked list
        ListNode mNode = head.next;
        //nNode is the head of the reversed linked list
        ListNode nNode = mNode;
        ListNode postnNode = nNode.next;
        
        for (int i = m; i < n; i++) {
            //use nNode function as prev 
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        prev.next = nNode;
        mNode.next = postnNode;
        return dummy.next;
    }
}