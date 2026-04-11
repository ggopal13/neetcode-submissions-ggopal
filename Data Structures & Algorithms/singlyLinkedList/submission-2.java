class LinkedList {

    private Node tail;
    private Node head;
    private int totalElements;

    public LinkedList() {
        this.tail = null;
        this.head = null;
        this.totalElements = 0;
    }

    public int get(int index) {
        if(index>=totalElements) return -1;
        return getIthNode(index).getValue();
    }

    public void insertHead(int val) {
        if(head == null){
            head = tail = new Node(val);
        }
        else{
            Node newHead = new Node(val);
            newHead.setNext(head);
            head = newHead;
        }
        totalElements++;
    }

    public void insertTail(int val) {
        if(head == null){
            head = tail = new Node(val);
        }
        else{
            Node newTail = new Node(val);
            tail.setNext(newTail);
            tail = newTail;
        }
        totalElements++;
    }

    public boolean remove(int index) {
        if(index>=totalElements) return false;
        if(index == 0){
            head = head.getNext();
        }
        else{
            Node beforeNode = getIthNode(index-1);
            beforeNode.setNext(beforeNode.getNext().getNext());
            if(index == totalElements-1)
            tail = beforeNode;
        }
        totalElements--;
        return true;
    }

    private Node getIthNode(int index){
        int count = 0;
        Node temp = head;
        while(count<index){
            temp = temp.getNext();
            count++;
        }
        return temp;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        while(temp!=null){
            list.add(temp.getValue());
            temp = temp.getNext();
        }
        return list;
    }
}

class Node {

    private int value;
    private Node next;

    public Node(int value){
        this.value = value;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public int getValue(){
        return this.value;
    }
}


