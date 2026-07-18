
class Node {
    public int val;
    public int key;
    public Node next;
    public Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    int cap;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        } else {
            Node node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addToHead(node);
        } else {
            if (map.size() == cap) {
                Node lastNode = tail.prev;
                map.remove(lastNode.key);
                removeNode(lastNode);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
        }
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addToHead(Node newNode) {
        Node firstNode = head.next; // ดักโหนดแรกเดิมเอาไว้
        head.next = newNode;
        newNode.next = firstNode;
        newNode.prev = head;
        firstNode.prev = newNode;
    }

}