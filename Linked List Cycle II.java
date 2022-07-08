/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow =head, fast=head;

        //find if cycle exists.
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                break;
            }
        }

        if(fast==null || fast.next==null)
            return null;

        //detect the node at which cycle starts.
        fast=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;

    }
}
