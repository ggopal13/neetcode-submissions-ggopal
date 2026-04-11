class LRUCache {

    private int size;
    private Node head;
    private Node tail;
    private Map<Integer,Node> map;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        int val = map.get(key).val;
        moveToLast(map.get(key));
        return val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node node = new Node(value);
            node.key = key;
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
            map.put(key,node);
        }
        else{
            map.get(key).val = value;
            moveToLast(map.get(key));
        }
        
        if(map.size() > this.size)
            removeHead();
    }

    private void moveToLast(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = tail;
        node.prev = tail.prev;
        node.prev.next = node;
        tail.prev = node;
    }

    private void removeHead(){
        Integer key = head.next.key;
        Node next = head.next.next;
        next.prev = head;
        head.next = next;
        map.remove(key);
        System.out.println("after deleting " + key + " " + map);
    }
}

class Node {
    int val;
    int key;
    Node prev;
    Node next;

    public Node(int val){
        this.val = val;
    }
}
