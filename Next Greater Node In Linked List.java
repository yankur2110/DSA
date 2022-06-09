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
    public int[] nextLargerNodes(ListNode head) {
        Stack<int[]> stack = new Stack<>();
        ListNode temp = head;
        int length=0;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        int[] resultArray = new int[length];

        int index=0;
        while(head!=null){
           while(!stack.isEmpty() && head.val>stack.peek()[1]){

               //since we need the index of the value as well, we are stack<int[]>.
               int[] result = stack.pop(); //0'th index represents the index and 1'th index represent the value.
               resultArray[result[0]]= head.val;
           }
           stack.push(new int[]{index++,head.val});
           head=head.next;
        }


        return resultArray;
    }
}
