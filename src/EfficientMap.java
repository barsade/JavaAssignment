import java.util.HashMap;
import java.util.Map;

public class EfficientMap {
    private class Node {
        String key;
        int value;
        Node next;
        Node previous;

        public Node() {}

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // HashMap to store key-value pairs
    private Map<String, Node> map;

    // Head and tail nodes for the doubly linked list
    private Node head;
    private Node tail;

    public EfficientMap() {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
    }

    public Integer put(String key, int value) {
        Node node = map.get(key);
        if (node != null) {
            // Key exists, update the value and move the node to the head to mark it as most recently accessed
            int oldValue = node.value;
            node.value = value;
            moveToHead(node);
            return oldValue;
        } else {
            // Key doesn't exist, create a new node and add to the head to mark it as most recently accessed
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            return null;
        }
    }

    public Integer remove(String key) {
        Node node = map.get(key);
        if (node != null) {
            // Remove the node from the linked list and the map
            removeNode(node);
            map.remove(key);
            return node.value;
        }
        return null;
    }

    public Integer get(String key) {
        Node node = map.get(key);
        if (node != null) {
            // Move the current node to the head, and mark it as most recently accessed
            moveToHead(node);
            return node.value;
        }
        return null;
    }

    public Integer getWarmest() {
        // Check if the list is empty, if not return the most recently accessed
        return head.next != tail ? head.next.value : null;
    }

    // Moves the specified node to the head of the list to mark it as most recently accessed
    private void addToHead(Node node) {
        node.previous = head;
        node.next = head.next;
        head.next.previous = node;
        head.next = node;
    }

    // Removes the specified node from the list
    private void removeNode(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}
