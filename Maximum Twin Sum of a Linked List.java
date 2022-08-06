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
    public int pairSum(ListNode head) {
        int n=0;
        ListNode temp=head;
        //find total nodes.
        while(temp!=null){
            temp=temp.next;
            n++;
        }

        //find mid index.
        int mid = (n-1)/2;
        int max=0;

        n=0;
        temp=head;

        //go till mid and reverse the linkedlist after that.
        while(temp!=null){
            if(n==mid+1){
                temp=reverse(temp);
                break;
            }
            n++;
            temp=temp.next;
        }

        //start adding corresponding elements of first half and reversed second half.
        while(temp!=null){
            max=Math.max(max, head.val+temp.val);
            head=head.next;
            temp=temp.next;
        }

        //return max.
        return max;
    }


    public ListNode reverse(ListNode head){
        ListNode prev=null, next=null;

        while(head!=null){
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }

        return prev;
    }
}
