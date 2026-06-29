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

                
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr1=head,curr2;
        
        for(int i=0; i<n; i++) {
            curr1 = curr1.next;
        }
        
        curr2=dummy;

        while(curr1!=null) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        curr2.next = curr2.next.next;
        return dummy.next;

    }
}
