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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

System.out.println("MID " + slow.val);
        ListNode mid = reverse(slow);

        ListNode m = mid;

        while(m!=null){
            System.out.println(m.val);
            m = m.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;

        while(head.next!=null){
            dummy.next = head;
            head=head.next;
            dummy = dummy.next;
            dummy.next = mid;
            mid = mid.next;
            dummy= dummy.next;
        }

        dummy.next = mid;

    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            System.out.print(curr.val + " ");
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
