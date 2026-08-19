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
   
    int count = 0;
    TreeNode result;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestRecur(root, k);
        return result.val;
    }

    public void kthSmallestRecur(TreeNode root, int k) {
        if (root == null|| count >= k) {
            return;
        }
        kthSmallestRecur(root.left, k);
        count++;
        if (count == k) {
            result = root;
        }
        kthSmallestRecur(root.right, k);
    }
}
