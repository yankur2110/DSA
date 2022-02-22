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
class BSTIterator {
    Stack<TreeNode> inorderElementStack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        //push all the left elements into the stack.
        while(root!=null){
            inorderElementStack.push(root);
            if(root.left!=null){
                root=root.left;
            }else{
                break;
            }
        }
    }

    public int next() {
        TreeNode topElement = inorderElementStack.pop(); //the element to be returned.
        TreeNode temp = topElement;

        if(temp.right!=null){ //check if there exists a right element of currentElement. If yes, then push that right child and all of left child's to stack.
            temp=temp.right;
            while(temp!=null){
                inorderElementStack.push(temp);

                if(temp.left!=null)
                    temp=temp.left;
                else
                    break;
            }
        }

        return topElement.val;
    }

    public boolean hasNext() {
        return !inorderElementStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
