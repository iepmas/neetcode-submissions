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
        ListNode prevGroup = dummy;

        ListNode kth = prevGroup;
        while (kth != null) {

            // try to go k ahead;
            for (int i = 0; i < k; i++) {
                kth = kth.next;

                if (kth == null) {
                    return dummy.next;
                }
            }

            // reverse between curr and k.
            // ListNode prev = prevGroup; <- mistake!
            ListNode nextGroup = kth.next;
            
            ListNode prev = nextGroup;
            ListNode curr = prevGroup.next;
            while (curr != nextGroup) {
                ListNode next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
            }

            // attach prevGroup and nextGroup to currGroup
            ListNode tmp = prevGroup.next;
            prevGroup.next = kth;

            kth = tmp;
            prevGroup = tmp;
        }
        return dummy.next;
    }
}

        // @ <- 1 <- 2 <- 3 -> 4 -> 5 -> 6 -> @
        
        // prevGroup      kth  nextGroup 
        //                prev
        //                     curr
        //                         next
