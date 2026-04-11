class Node {
    int val;
    Node next;

    public Node(int val){
        this.val = val;
    }
}

class MyCircularQueue {

    Node head;
    Node tail;
    int maxSize;
    int count;

    public MyCircularQueue(int k) {
        this.maxSize = k;
        this.head = null;
        this.tail = null;
        this.count = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        Node newNode = new Node(value);

        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        head = head.next;

        if(head == null)
            tail = null;
        
        count--;

        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return head.val;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        return head == null && tail == null;
    }
    
    public boolean isFull() {
        return maxSize == count;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */