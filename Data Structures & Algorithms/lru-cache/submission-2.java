public class Node {
    int key;
    int val;

    Node prev;
    Node next;
    
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> cache = new HashMap<>();

    // dummies
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            // create and put at front (MRU):
            Node node = new Node(key, value);
            add(node);
            cache.put(key, node);
        } else {
            // update key:
            Node node = cache.get(key);
            remove(node);
            node.val = value;
            add(node);
        }

        if (cache.size() > this.capacity) {
            // remove LRU item:
            cache.remove(tail.prev.key);
            remove(tail.prev);
        }

    }

    // helpers
    // given a target node, remove it.
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // add a target node to the front of doubly linked list.
    private void add(Node node) {
        Node tmp = head.next;
        
        node.next = tmp;
        node.prev = head;

        head.next = node;
        tmp.prev = node;
    }

}
