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
    TreeNode parentOfToBeDeleted = null;
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;

        //first check if the key exists in the tree or not.
        TreeNode toBeDeleted = findNode(root, key, null);
        if(toBeDeleted==null) return root;

        //case 1: toBeDeleted node is a leaf node.
        if(toBeDeleted.left==null && toBeDeleted.right==null){
            if(root==toBeDeleted) return null; //if only one node is there and that is to be deleted.
            if(parentOfToBeDeleted.left==toBeDeleted){
                parentOfToBeDeleted.left=null;
            }else{
                parentOfToBeDeleted.right=null;
            }
        }else if(toBeDeleted.left==null){ //case 2: toBeDeleted's left is null but right has value.
            toBeDeleted.val=toBeDeleted.right.val;
            toBeDeleted.left=toBeDeleted.right.left;
            toBeDeleted.right=toBeDeleted.right.right;
        }else if(toBeDeleted.right==null){//case 3: toBeDeleted's right is null but left has value.
            toBeDeleted.val=toBeDeleted.left.val;
            toBeDeleted.right=toBeDeleted.left.right;
            toBeDeleted.left=toBeDeleted.left.left;
        }else{ //case 4: if both sides have subtree.
            swap(toBeDeleted, toBeDeleted.right);
        }
        //no need to consider case 5 explicitly i.e, if it's a root node because we are just swapping values and changing the reference.
        return root;
    }

    //this method checks if the node to be deleted exists in the tree or not. If it exists, store it's parent in 'parentOfToBeDeleted' reference.
    public TreeNode findNode(TreeNode root, int key, TreeNode parent){
        if(root==null || root.val==key){
            parentOfToBeDeleted=parent;
            return root;
        }
        if(key<root.val) return findNode(root.left, key, root);
        return findNode(root.right, key, root);
    }


    //In case 4, we have two options either to swap with max of left subtree or swap with min of right subtree.
    public void swap(TreeNode toBeDeleted, TreeNode itsRight){
        //we are swapping right subtree least value to 'toBeDeleted' node.
        if(itsRight.left==null){
            toBeDeleted.val=itsRight.val;
            toBeDeleted.right=itsRight.right;
        }else{
            TreeNode prev = itsRight;
            while(itsRight.left!=null){
                prev=itsRight;
                itsRight=itsRight.left;
            }
            toBeDeleted.val=prev.left.val;
            prev.left=itsRight.right;
        }
    }
}
