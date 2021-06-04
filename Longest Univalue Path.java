class Solution {
    int max=0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root){

          if(root==null)
             return 0;

         int poss1=0,poss2=0,poss3=0;
        
         poss1=helper(root.left);
         poss2=helper(root.right);

         //TO MAKE SURE WE CONSIDER ONLY THE SINGLE PATH i.e., LEFT_SUBTREE/RIGHT_SUBTREE IS CONNECTED TO ROOT, BECAUSE THIS WE NEED TO RETURN TO CALLER METHOD.
         int leftCheck=0,rightCheck=0;

         if(root.left!=null && root.val==root.left.val){
             leftCheck = poss1+1;
         }
         if(root.right!=null && root.val==root.right.val){
             rightCheck = poss2+1;            
         }
         max = Math.max(max,rightCheck+leftCheck);

         return Math.max(leftCheck,rightCheck);

    }
}
