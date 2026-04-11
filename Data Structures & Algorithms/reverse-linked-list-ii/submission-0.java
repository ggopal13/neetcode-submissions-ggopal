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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        int count = 0;
        ListNode leftPrev = dummyHead;
        ListNode rightNext = dummyHead;

        while(count < left-1){
            leftPrev = leftPrev.next;
            rightNext = rightNext.next;
            count++;
        }

        while(count < right+1){
            rightNext = rightNext.next;
            count++;
        }

        ListNode leftStart = leftPrev.next;
        ListNode reversedHead = reverse(leftPrev.next, rightNext);

        leftPrev.next = reversedHead;
        leftStart.next = rightNext;

        return dummyHead.next;

    }

    private ListNode reverse(ListNode head, ListNode end){
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=end){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}