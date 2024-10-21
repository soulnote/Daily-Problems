import java.util.HashMap;

class LRUCache {

    // Define the node class for the doubly linked list
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map; // stores key and node reference
    private int capacity; // cache capacity
    private Node head, tail; // pointers to the head and tail of the doubly linked list

    // Constructor to initialize cache with capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head node
        this.tail = new Node(0, 0); // Dummy tail node
        head.next = tail;
        tail.prev = head;
    }

    // Get value from cache
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1; // Key not found
        }
        Node node = map.get(key);
        remove(node);  // Remove the node from its current position
        insertToHead(node); // Move it to the head (most recently used)
        return node.value;
    }

    // Put value into cache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node); // Remove the node and update its position
            insertToHead(node); // Insert at the head again
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key); // Remove the least recently used node (tail.prev)
                remove(tail.prev);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertToHead(newNode); // Insert the new node at the head
        }
    }

    // Remove a node from the doubly linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert a node to the head of the doubly linked list
    private void insertToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

