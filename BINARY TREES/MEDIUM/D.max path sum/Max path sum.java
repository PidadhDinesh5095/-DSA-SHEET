/**
path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 
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
  int m=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       if(root==null)return 0;
      if(root.left==null && root.right==null)return root.val;
       findmaxpath(root);
      return m;
    }
  private int findmaxpath(TreeNode root){
    if(root==null)return 0;
    int l=Math.max(0,findmaxpath(root.left));
    int r=Math.max(0,findmaxpath(root.right));
    m=Math.max(m,l+r+root.val);
    return Math.max(l,r)+root.val;
  }
}
