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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1); //taking dummy1 and dummy2 because we don't what would be the starting values in these. Handling it would be a bit messy, hence just take these dummy nodes and dummy.next would be what we would be looking for.
        ListNode dummy2 = new ListNode(-1);
        ListNode tail1 = dummy1, tail2 = dummy2; //use tails to iterate because dummy1 and dummy2, we would need later.

        while(head!=null){
            if(head.val<x){ //if current<x then add to list1.
                tail1.next = new ListNode(head.val);
                tail1=tail1.next;
            }else{ //otherwise add to list2.
                tail2.next = new ListNode(head.val);
                tail2=tail2.next;
            }
            head=head.next;
        }
        tail1.next=dummy2.next; //join the two lists.

        return dummy1.next; //return head from dummy1.
    }
}
