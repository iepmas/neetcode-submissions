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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (c1 != null || c2 != null) {
            if (c1 == null) {
                ListNode tmp = new ListNode((c2.val + carry) % 10);
                curr.next = tmp;
                
                carry = (c2.val + carry >= 10) ? 1 : 0;
                
                curr = tmp;
                c2 = c2.next;
                continue;
            }

            if (c2 == null) {
                ListNode tmp = new ListNode((c1.val + carry) % 10);
                curr.next = tmp;
                
                carry = (c1.val + carry >= 10) ? 1 : 0;
                
                curr = tmp;
                c1 = c1.next;
                continue;
            }

            ListNode tmp = new ListNode((c1.val + c2.val + carry) % 10);
            carry = (c1.val + c2.val + carry) >= 10 ? 1 : 0;

            curr.next = tmp;
            curr = tmp;

            c1 = c1.next;
            c2 = c2.next;
        }

        if (carry == 1) {
            curr.next = new ListNode(1);
        }
        return dummy.next;
    }
}
