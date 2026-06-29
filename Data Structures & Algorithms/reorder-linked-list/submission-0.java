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
        ListNode slow=head, fast=head, prev=null;
        while(fast!=null && fast.next!=null) {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        if(fast!=null && fast.next==null) {
            prev=slow;
            slow=slow.next;
        }

        prev.next = null;
            
        ListNode head2 = reverse(slow); 

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode currHead1 = head, currHead2 = head2, tmp;

        // print(currHead1);
        // print(currHead2);

        while(currHead1!=null && currHead2!=null) {
            
            curr.next = currHead1;
            currHead1 = currHead1.next;
            
            curr.next.next = currHead2;
            currHead2 = currHead2.next;

            curr = curr.next.next;
        }
        
        if(currHead1!=null) curr.next = currHead1;
        if(currHead2!=null) curr.next = currHead2;

        head =  dummy.next;

    }

    public ListNode reverse(ListNode head) {
        if(head == null)
            return head;
        
        ListNode curr=head,prev=null,next=null;

        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void print(ListNode head) {
        if(head == null)
            return;

        System.out.print("-> ");
        
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}
