class LFUCache {

    private int cap;
    private Map<Integer,DLL> freqMap;
    private Map<Integer,Node> valMap;
    private int minFreq;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.freqMap = new HashMap<>();
        this.valMap = new HashMap<>();
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if(!valMap.containsKey(key))
            return -1;
        
        Node node = valMap.get(key);
        incrementFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        
        if(valMap.containsKey(key)){
            valMap.get(key).value = value;
            incrementFrequency(valMap.get(key));
            return;
        }

        if(valMap.size() == this.cap){
            DLL list = freqMap.get(this.minFreq);
            Node node = list.removeFirst();
            if(list.length() == 0)
                freqMap.remove(this.minFreq);
            valMap.remove(node.key);
        }

        Node newNode = new Node(key,value,1);
        valMap.put(key,newNode);
        addToFreqMap(1,newNode);
        this.minFreq = 1;

        System.out.println(freqMap);
        System.out.println(valMap);
    }

    private void incrementFrequency(Node node){
        int freq = node.frequency;
        node.frequency = freq+1;

        DLL list = freqMap.get(freq);
        list.remove(node);

        if(list.length() == 0){
            freqMap.remove(freq);
            if(minFreq == freq)
                minFreq = freq + 1;
        }

        addToFreqMap(node.frequency,node);
    }

    private void addToFreqMap(int freq,Node node){
        freqMap.putIfAbsent(node.frequency,new DLL());
        freqMap.get(node.frequency).insert(node);
    }
}

class Node {
    int value;
    int key;
    int frequency;

    Node next;
    Node prev;

    public Node (int key, int value, int frequency){
        this.key = key;
        this.value = value;
        this.frequency = frequency;
    }
}

class DLL {

    private Node head;
    private Node tail;
    private int length;
    
    public DLL(){
        this.head = new Node(-1,-1,-1);
        this.tail = new Node(-1,-1,-1);
        head.next = tail;
        tail.prev = head;
        this.length = 0;
    }

    public void insert(Node node){
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        tail.prev = node;
        node.next = tail;
        this.length++;
    }

    public Node remove(Node node){
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
        this.length--;
        return node;
    }

    public Node removeFirst(){
        return remove(head.next);
    }

    public int length(){
        return this.length;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */