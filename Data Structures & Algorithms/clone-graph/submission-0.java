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
        return cloneGraph(node, new HashMap<Node,Node>());
    }
    private Node cloneGraph(Node node, HashMap<Node,Node> visited){
         if(node==null){
            return null;
        }
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        ArrayList<Node> neighbors = new ArrayList<Node>();
        Node newNode = new Node(node.val, neighbors);
        visited.put(node, newNode);
        for(Node neighbor: node.neighbors){
            neighbors.add(cloneGraph(neighbor, visited));
        }
        return newNode;
    }
    
}