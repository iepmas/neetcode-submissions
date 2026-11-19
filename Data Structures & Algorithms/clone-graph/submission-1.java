/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Set<Node> visited = new HashSet<>();
    HashMap<Node, Node> map = new HashMap<>();

    private Node bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        
        Node copy = new Node(node.val);
        
        map.put(node, copy);
        visited.add(node);
        q.add(node);
        
        while (!q.isEmpty()) {
            Node original = q.poll();
            copy = map.get(original);
            //process vertex early

            for (Node neighbor : original.neighbors) {

                if (!visited.contains(neighbor)) {
                    Node tmp = new Node(neighbor.val);
                    map.put(neighbor, tmp);
                    visited.add(neighbor);
                    q.offer(neighbor);
                }

                // process edge
                copy.neighbors.add(map.get(neighbor));

            }
            // process vertex late.
        }
        return map.get(node);
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        if (node.neighbors.isEmpty() ) {
            return new Node(node.val);
        }

        Node copy = bfs(node);
        return copy;
    }
}
