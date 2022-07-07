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
    public ListNode[] splitListToParts(ListNode head, int k) {
        //if no list is there but we want the split parts.
        if(head==null)
            return new ListNode[k];

        int n=0;
        ListNode temp = head, prev=head;
        //first calculate the length of the list.
        while(temp!=null){
            n++;
            temp=temp.next;
        }

        //find what should be the least length, and how many would nodes will still be remaining.
        int len = n/k;
        int mod = n%k; //these are leftover nodes. We will assign them (1 by one) to each part from start.
        int tempLength=0;

        ListNode[] splittedListArray =  new ListNode[k];
        int i=0;

        //start iterating through the list;
        while(head!=null && k-->0){

            //assign the head.
            splittedListArray[i++]= head;

            //assigning the leftovers.
            tempLength=len;
            if(mod-->0){
                tempLength++;
            }

            //incrementing the head for next iteration.
            while(head!=null && tempLength-->0){
                prev=head;
                head=head.next;
            }
            prev.next=null; //split the list which we have set.

        }

        while(k-->0){ //if still k splits aren't generated, initialize with null.
           splittedListArray[i++]= null;
        }

        //return the splitted array.
        return splittedListArray;

    }
}
