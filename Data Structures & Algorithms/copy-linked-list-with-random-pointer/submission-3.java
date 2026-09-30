/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        Node copyHead = new Node(-1);
        Node copyCurr = copyHead;

        while (curr != null) {
            Node tmp = new Node(curr.val);
            copyCurr.next = tmp;

            // put in map
            map.put(curr, tmp);

            copyCurr = copyCurr.next;
            curr = curr.next;
        }

        copyCurr = copyHead.next;
        curr = head;
        while (curr != null) {
            Node original = curr.random;
            copyCurr.random = map.get(original);
            
            copyCurr = copyCurr.next;
            curr = curr.next;
        }

        return copyHead.next;
    }
}
