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

public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Fast-fail for an empty tree
        if (root == null) {
            return "null";
        }

        StringBuilder strBuilder = new StringBuilder();
        Queue<TreeNode> bfsListQue = new LinkedList<>();
        bfsListQue.add(root);

        while (!bfsListQue.isEmpty()) {
            TreeNode treeNode = bfsListQue.poll();

            if (treeNode == null) {
                strBuilder.append("null,");
            } else {
                strBuilder.append(treeNode.val).append(",");
                // We add children even if they are null, so they get serialized as "null" later
                bfsListQue.add(treeNode.left);
                bfsListQue.add(treeNode.right);
            }
        }

        return strBuilder.toString(); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) { 
        // Fast-fail for an empty tree
        if (data.equals("null") || data.isEmpty()) {
            return null;
        }

        String[] split = data.split(","); 

        // Safely create the root using the first string
        TreeNode rootNode = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> bfsListQue = new LinkedList<>();
        bfsListQue.add(rootNode);

        // Pointer to track our position in the string array
        int i = 1;

        while (!bfsListQue.isEmpty() && i < split.length) {
            TreeNode current = bfsListQue.poll();

            // --- Process the Left Child ---
            if (!split[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(split[i]));
                bfsListQue.add(current.left);
            }
            i++;

            // --- Process the Right Child ---
            // Check bounds just in case the string ends perfectly
            if (i < split.length && !split[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(split[i]));
                bfsListQue.add(current.right);
            }
            i++;
        }

        return rootNode;
    }

}
