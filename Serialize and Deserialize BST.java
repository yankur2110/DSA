/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    String str = "";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        traversalHelper(root);
        return str;

    }

    public void traversalHelper(TreeNode root){
        if(root==null){ str+="N,"; return;}
        str+=root.val+",";
        traversalHelper(root.left);
        traversalHelper(root.right);

    }

    public TreeNode buildTree(Queue<String>  nodes){
        String val = nodes.remove();

        if (val.equals("N")) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
