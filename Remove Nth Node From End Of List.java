/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        /*
        simply giving n+1 lead to second one, so that when first reaches last first will be lagging n behind. because we are making fast pointer pointing to null.
        */
        
        ListNode dummy_node = new ListNode(0);
        dummy_node.next = head;
        ListNode slow = dummy_node;
        ListNode fast = dummy_node;
        
        for(int i=0;i<=n;i++){ //core part..diff is n+1
            fast = fast.next;
        }
        
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        
        slow.next = slow.next.next;
        
        
        return dummy_node.next;
        
    }
}