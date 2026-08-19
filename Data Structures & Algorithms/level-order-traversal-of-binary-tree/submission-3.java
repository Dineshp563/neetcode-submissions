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

        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = treeNodeQueue.poll();
                levelList.add(poll.val);
                
                if (poll.left != null) {
                    treeNodeQueue.add(poll.left);
                }
                if (poll.right != null) {
                    treeNodeQueue.add(poll.right);
                }
            }
            lists.add(levelList);
        }

        return lists;
    }

}
