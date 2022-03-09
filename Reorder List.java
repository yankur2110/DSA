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

    //here in test cases they are checking first N nodes only provided there is no loop. I think so.
    public void reorderList(ListNode head) {
        Stack<ListNode> nodesStack = new Stack<>(); //take stack.
        ListNode temp = head, next;
        int count=0;
        while(temp!=null){ //push to stack and count them.
            nodesStack.push(temp);
            temp=temp.next;
            count++;
        }

        temp=head;
        for(int i=0;i<count/2;i++){ //alternatively keep on adding to the actual list.
            next= temp.next;
            temp.next=nodesStack.pop();
            temp.next.next=next;
            temp=next;
        }
        temp.next=null;

    }
}
