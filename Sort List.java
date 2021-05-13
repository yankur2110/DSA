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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        /* here note that if you using this method for finding middle node. You will get the higher end of middle eleent in case of even nodes. For example for 4->2->1->3, you will get 1 as the middle element. */

        prev.next=null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        //now merge the sorted lists
        return merge(l1,l2);

    }

    ListNode merge (ListNode l1, ListNode l2){

        ListNode initialNull= new ListNode(0);
        ListNode toBeReturned=initialNull;
        while(l1!=null && l2!=null){

            if(l1.val<=l2.val){
                initialNull.next=l1;
                l1=l1.next;
            }else{
                initialNull.next=l2;
                l2=l2.next;
            }
            initialNull=initialNull.next;
        }

        if (l1 != null)
            initialNull.next = l1;

        if (l2 != null)
            initialNull.next = l2;


        return toBeReturned.next;
    }
}