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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0,null);
        ListNode toReturn = root;// we will return root.next in the end..
        
        while(head!=null){
            
             ListNode countNode= head;
             int count =0;  
            /*checking if the number of nodes in consideration are more than k or not*/
             while(countNode!=null && count!=k){
                 countNode=countNode.next;
                 count++;
             }

            if(count==k){
                //adding new reverse group to prev k-reversed group nodes.
                root.next=reverse(head,k);
                //pointing the rev to the tail of till formed reverselist.
                while(root.next!=null){
                    root=root.next;
                }

            }else{
                //If number of remaining nodes are less than k.
                root.next=head;
            }
        
            head=countNode;
        }
        
        return toReturn.next;
        
    }
    
    /*
    this function reverse k number of nodes including head Node.
    */
    public ListNode reverse( ListNode head, int k){
        ListNode prev=null,next=null;
        int count=0;
        
        while(head!=null && count++<k){
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}