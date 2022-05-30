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
        ListNode temp = head, prev = null;
        int count = left;
        while(--count>0){ //setting prev at required position so that returned node from list can be assigned to next of this prev.
            prev = temp;
            temp=temp.next;
        }

        if(prev!=null){ //if left is not the start node.
            prev.next=rev(temp,right-left);
            return head;
        }
        else //if left is the start node then simply return the node from reverse function.
            return rev(temp,right-left);

    }

    public ListNode rev(ListNode head, int lenToBeReversed){
        ListNode prev = null, next = null, temp = head;
        int tempCount = lenToBeReversed;
        while(lenToBeReversed-->0){ //point temp to right index node.
            temp=temp.next;
        }
        prev=temp.next; //generally we start prev with null but here we would start prev with temp.next as per the need.
        temp.next=null; //so that only required length list is reversed.

        //now do the normal reverse.
        while(head!=null){
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
