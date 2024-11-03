/**
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
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
class Solution{
    private int m=0;
    public int diameterOfBinaryTree(TreeNode root) {
       if(root==null)return 0 ;
       height(root);
      return m;
    }
  private int height(TreeNode r){
    if(r==null)return 0 ;
    int lh=height(r.left);
    int rh=height(r.right);
    m=Math.max(m,lh+rh);
    return Math.max(lh,rh)+1;   
  }
}
