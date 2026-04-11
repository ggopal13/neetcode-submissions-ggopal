/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        return recurse(head,new HashMap<>());
    }

    private Node recurse(Node head, Map<Node,Node> map){
        if(head == null)
            return null;

        if(map.containsKey(head)) return map.get(head);

        Node copy = new Node(head.val);
        map.put(head,copy);
        copy.next = recurse(head.next, map);
        copy.random = map.get(head.random);
        return copy;
    }
}
