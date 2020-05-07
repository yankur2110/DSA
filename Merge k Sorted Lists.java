/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        /*here we are going to use a min-heap, firstly we will add all the elements to the heap and then will remove the elements and add to a linkedlist*/
        
        if(lists.length<1){
            return null;
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for(ListNode node: lists){
            while(node!=null){
                heap.add(node.val);
                node=node.next;
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while(!heap.isEmpty()){
            dummy.next= new ListNode(heap.poll());
            dummy = dummy.next;
            
        }
        
        return head.next;
    }
}