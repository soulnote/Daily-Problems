/*
// Definition for a Node.
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
        if (node == null) {
            return null; // Handle the edge case of an empty graph
        }

        // A map to store the mapping between original nodes and their clones
        Map<Node, Node> map = new HashMap<>();

        // Create the clone for the starting node
        Node clone = new Node(node.val);
        map.put(node, clone);

        // BFS queue to traverse the graph
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Iterate through the neighbors of the current node
            for (Node neighbor : current.neighbors) {
                // If this neighbor hasn't been cloned yet
                if (!map.containsKey(neighbor)) {
                    // Create and store the clone
                    Node neighborClone = new Node(neighbor.val);
                    map.put(neighbor, neighborClone);

                    // Add the neighbor to the queue for processing
                    queue.add(neighbor);
                }

                // Add the clone of the neighbor to the clone of the current node
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }

        // Return the clone of the starting node
        return clone;
    }
}
