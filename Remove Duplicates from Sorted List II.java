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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev=null, tempHead=head;


        //aim is to point head and head.next at two distinct values.
        while(head!=null){

            boolean repeationFound=false;
            //keep on skipping repeated nodes.
            while(head!=null && head.next!=null && head.val == head.next.val){
                repeationFound=true;
                head=head.next;
            }

            //if repeation was found.
            if(repeationFound){
                head=head.next;
                if(prev!=null) //repetition not there in start.
                    prev.next=head;
                else{ //repetition present at start.
                    tempHead=head;
                }
                continue;
            }

            //if not repetition found simply go to next node.
            prev=head; head=head.next;
        }

        //needed a tempHead because there might be a case where repetition was there in start.
        return tempHead;

    }
}Remove Duplicates from Sorted List II
