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

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;    
    }
    
    public int get(int key) {
        Node curr = cache.get(key);
        if (curr == null) {
            return -1;
        }
        remove(curr);
        insert(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node existing = cache.get(key);
            remove(existing);
            cache.remove(key);
        } else if (cache.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
        cache.put(key, newNode);
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        prev.next = next;
        next.prev = prev;
        return;
    }

    private void insert(Node node) {
        Node next = head.next;

        node.next = next;
        node.prev = head;

        head.next = node;
        next.prev = node;
    }
}
