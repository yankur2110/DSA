/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode head = l3;
        
        if(l1==null && l2==null){
            return null;
        }
        
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                l3.val=l1.val;
                l3.next=new ListNode();
                l3=l3.next;
                l1=l1.next;
            }else if(l2.val<l1.val){
                l3.val=l2.val;
                l3.next=new ListNode();
                l3=l3.next;
                l2=l2.next;
            }
        }
        
        if(l1==null && l2!=null){
            l3.val=l2.val;
            l3.next=l2.next;
            
        }
        
        else if(l1!=null && l2==null){
            l3.val=l1.val;
            l3.next = l1.next;
        }
        
        return head;
    }
}