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
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return false;
        ListNode slow = head,fast = head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //here it is important to note that above method gives the upper element of middle, in case of even elements. Also in case of even elements fast will be at null whereas in case of odd elements fast won't be null, fast.next would be null.
        
        if(fast!=null)
            slow = slow.next;
        slow = reverse (slow);
        
        while(slow!=null){
            if(slow.val!=head.val)
                return false;
            slow=slow.next;
            head=head.next;
        }
        return true;
    }
    
    public ListNode reverse (ListNode curr){
        
        ListNode next=null,prev=null;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
        
        
    }
}
