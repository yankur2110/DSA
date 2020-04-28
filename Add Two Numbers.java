/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        ListNode result = new ListNode();
        ListNode currentHead = result;
        ListNode prev = result;


        while(l1!=null || l2!=null){

            if(l1!=null && l2!=null)
             carry= carry + l1.val+l2.val;
            else if (l2!=null)
                carry = carry +l2.val;
            else
                carry = carry+l1.val;

            if(carry>9){
                result.val= carry%10;
                carry = carry/10;
                result.next =  new ListNode();
                prev = result;
                result = result.next;
            }
            else {
                result.val = carry;
                result.next =  new ListNode();
                prev = result;
                result = result.next;
                carry = 0;
            }
            if(l1!=null)
                l1= l1.next;
            if(l2!=null)
                l2=l2.next;
        }

        if(carry!=0){
            prev.next = new ListNode();
            prev= prev.next;
            prev.val = carry;
        }
        prev.next = null;
        return currentHead;
    }
    
    
    
}