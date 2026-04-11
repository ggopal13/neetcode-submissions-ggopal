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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;

        while(l1!=null && l2!=null){
            int sum = carry + l1.val + l2.val;
            carry = sum/10;
            int val = sum%10;
            ListNode node = new ListNode(val);
            curr.next = node;
            curr = node;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            int sum = carry + l1.val;
            carry = sum/10;
            int val = sum%10;
            ListNode node = new ListNode(val);
            curr.next = node;
            curr = node;
            l1 = l1.next;
        }

        while(l2!=null){
            int sum = carry + l2.val;
            carry = sum/10;
            int val = sum%10;
            ListNode node = new ListNode(val);
            curr.next = node;
            curr = node;
            l2 = l2.next;
        }

        if(carry > 0){
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
