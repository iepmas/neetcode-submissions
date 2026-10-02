/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        ListNode kth = groupPrev;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (kth.next == null) {
                    return dummy.next;
                }
                kth = kth.next;
            }

            ListNode groupNext = kth.next;

            // perform reversal:
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                
                prev = curr;
                curr = next;
            }
            
            // groupPrev is previous group. Up until now, it holds the end of the reversed list. So groupPrev.next is the end of the previous group for the next group.
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            
            kth = tmp;
            groupPrev = tmp;
        }
    }
}
