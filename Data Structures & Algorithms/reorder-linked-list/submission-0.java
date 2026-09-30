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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;            
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode mid = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            mid = mid.next;
        }

        ListNode l1 = head;
        ListNode l2 = reverseList(mid);

        while (l2.next != null) {
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;
            l1.next = l2;
            l2.next = tmp1;
            l1 = tmp1;
            l2 = tmp2;
        }
    }
}
