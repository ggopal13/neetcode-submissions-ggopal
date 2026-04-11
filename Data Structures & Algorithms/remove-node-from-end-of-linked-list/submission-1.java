/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode rHead = reverse(head);

        if(n==1)
            return reverse(rHead.next);
        
        int count = 1;

        ListNode prev = null;
        ListNode curr = rHead;

        while(count!=n){
            prev = curr;
            curr = curr.next;
            count++;
        }

        prev.next = curr.next;

        return reverse(rHead);

    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
