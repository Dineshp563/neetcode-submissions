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


    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serializeDfsRecur(root, builder);
        return builder.toString();
    }


    public void serializeDfsRecur(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("null,");
            return;
        }
        builder.append(root.val).append(",");
        serializeDfsRecur(root.left, builder);
        serializeDfsRecur(root.right, builder);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> bfsListQue = new LinkedList<>();
        for (String str : data.split(",")) {
            bfsListQue.add(str);
        }
        return deserializeDfsRecur(bfsListQue);

    }

    public TreeNode deserializeDfsRecur(Queue<String> bfsListQue) {
        String value = bfsListQue.poll();
        if ("null".equalsIgnoreCase(value)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeDfsRecur(bfsListQue);
        node.right = deserializeDfsRecur(bfsListQue);
        return node;
    }

}
