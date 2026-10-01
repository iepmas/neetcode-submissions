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
    public ListNode mergeKLists(ListNode[] lists) {
        // initial setup:
        Comparator<ListNode> comparator = (n1, n2) -> Integer.compare(n1.val, n2.val);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(comparator);
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        // loop:
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            
            curr.next = node;
            curr = curr.next;

            // if that list is not empty, add its next element to the PQ
            if (node.next != null) {
                pq.add(node.next);
                node.next = null;
            }
        }
        return dummy.next;
    }
}
