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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null; //if null, then return null.
        if(head.next==null) return new TreeNode(head.val); //if it's the only element, then create a treeNode with null childs.

        ListNode slow=head, fast=head, prev= null;

        while(fast!=null && fast.next!=null){ //to find the middle element.
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        if(prev!=null){ //keep track of previous to middle element, to break the link therefore that can be treated as subtree.
            prev.next=null;
        }

        TreeNode root = new TreeNode(slow.val); //set middle element as root.
        root.left= sortedListToBST(head); //left subtree would start from head to mid.
        root.right= sortedListToBST(slow.next); //right substree would start from mid+1 to end.

        return root;
    }

}
