/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> resultList = new ArrayList<>();
        HashMap<Integer, TreeNode> parentMap = new HashMap<>();
        HashSet<Integer> visitedNodes = new HashSet<>();
        
        populateParentMap(parentMap, root);
        Queue<TreeNode> normalQueue = new LinkedList<>(); 
        
        normalQueue.add(target);
        int currDist=0;
        
        while(normalQueue.size()>0){
            int size = normalQueue.size();
            
            for(int i=0;i<size;i++){
                
                TreeNode node = normalQueue.poll();
                visitedNodes.add(node.val);
                
                
                //check the distance of nodes in queue from targetNode, if it's K add to the resultList.
                if(currDist==k){
                    resultList.add(node.val);
                }
                
                //check if current node's left and right childs are not null and not visited.
                if(node.left!=null && !visitedNodes.contains(node.left.val)){
                    normalQueue.add(node.left);
                }
                if(node.right!=null && !visitedNodes.contains(node.right.val)){
                    normalQueue.add(node.right);
                }
                
                //if the node has a parent which is not visited yet.
                if(parentMap.containsKey(node.val)){
                    TreeNode parent = parentMap.get(node.val);
                    if(!visitedNodes.contains(parent.val)){
                        normalQueue.add(parent);
                    }
                }
                
                
            }
            
            currDist++;
            
            if(resultList.size()!=0)
                return resultList;
            
            
        }
        
        return resultList;
    }
    
    //simply while traversing a tree.. check if a node has any child, if yes then set the current node as the parent of child nodes.
    public void populateParentMap(HashMap<Integer, TreeNode> parentMap, TreeNode root){
        
        if(root==null)
            return;
        
        if(root.left!=null)
            parentMap.put(root.left.val, root);
        
        if(root.right!=null)
            parentMap.put(root.right.val, root);
        
        populateParentMap(parentMap, root.left);
        populateParentMap(parentMap, root.right);
        
    }
}