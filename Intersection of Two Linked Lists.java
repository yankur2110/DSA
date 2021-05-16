/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenOfA = 0;
        int lenOfB = 0;
        ListNode tempA=headA;
        ListNode tempB=headB;
        
        while(tempA!=null || tempB!=null){
            if(tempA!=null){
                lenOfA++;
                tempA=tempA.next;
            }
            if(tempB!=null){
                lenOfB++;
                tempB=tempB.next;
            }
            
        }
        
        ListNode ref = lenOfA>lenOfB?headA:headB;
        
        ListNode other = null;
        
        if(ref==headA)
            other=headB;
        else
            other=headA;
        
        int extraNodes = Math.abs(lenOfA-lenOfB);
        
        while(extraNodes>0){
            ref=ref.next;
            extraNodes--;
        }
        
        while(ref!=null && other!=null){
            if(ref==other)
                return ref;
            ref=ref.next;
            other=other.next;
            
        }
        
        return null;
        
        
    }
}