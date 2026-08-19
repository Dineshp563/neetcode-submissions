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
    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrderRecur(root, new ArrayList<List<Integer>>(), 0);
    }

    private List<List<Integer>> levelOrderRecur(TreeNode root, ArrayList<List<Integer>> lists, int level) {
        
        if (root == null) {
            return lists;
        } else if (lists.size() == level) {
            lists.add(new ArrayList<Integer>());
        }
        lists.get(level).add(root.val); 
        levelOrderRecur(root.left, lists, level + 1);
        levelOrderRecur(root.right, lists, level + 1);
        return lists;
    }

}
