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
        HashMap<Node, Node> nodeHashMap = new HashMap<>();
        return cloneGraph(node, nodeHashMap);
    }

    private Node cloneGraph(Node node, HashMap<Node, Node> nodeHashMap) {
        if (nodeHashMap.containsKey(node)) {
            return nodeHashMap.get(node);
        }
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.val);
        nodeHashMap.put(node, newNode);
        List<Node> neighbors = node.neighbors;
        List<Node> newNeighbors = new ArrayList<>();
        for (Node listNode : neighbors) {
            newNeighbors.add(cloneGraph(listNode, nodeHashMap));
        }
        newNode.neighbors = newNeighbors;
        return newNode;
    }
}