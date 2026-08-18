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
    

   
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null ) {
            return false;
        }
        boolean isSubTree =  isSameTree(root, subRoot);
        return isSubTree || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null){
            return p==q;
        }
        if (p.val != q.val) {
            return false;
        }

        boolean isLeftSameTree = isSameTree(p.left, q.left);
        boolean isRightSameTree = isSameTree(p.right, q.right);
        return isLeftSameTree && isRightSameTree;
    }
}
