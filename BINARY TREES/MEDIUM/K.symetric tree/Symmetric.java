//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if(p==null || q==null)return p==q;
      return ((q.val==p.val)&&isSameTree(p.left,q.right)&&isSameTree(p.right,q.left));

    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return false;
        return isSameTree(root.left,root.right);
    }
}
