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
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return head;
        ListNode currentOdd = head;
        ListNode evenHead=head.next;
        ListNode currentEven = head.next;
        
        //currentEven would be null for oddLength, currentOdd would be null for evenLength.
        while(currentEven!=null && currentEven.next!=null){
            currentOdd.next=currentEven.next;
            currentOdd=currentOdd.next;
            currentEven.next=currentOdd.next;
            currentEven=currentEven.next;
            
            currentOdd.next=evenHead;
        }
        
        return head;
        
    }
}
