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
    
    public Node cloneGraph(Node node) {
        if (node == null) return null; // 1. Null check first!
        HashMap<Node, Node> visited = new HashMap<>();
        return cloneGraphDFS(node, visited);
    }

    private Node cloneGraphDFS(Node node, HashMap<Node, Node> visited) {
        // 2. Map check second
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 3. Create and Save
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // 4. Explore and Add directly to the clone's list
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraphDFS(neighbor, visited));
        }

        return clone;
    }
}