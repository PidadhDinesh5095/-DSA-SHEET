
/**Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 



Input: root = [3,1,4,null,2], k = 1
Output: 1
  **/
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
  int c=0;
  int ks=0;
  private void find(TreeNode root ,int k){
    if(root==null || c>=k)return ;
    find(root.left,k);
    c++;
    
    if(c==k){
      ks=root.val;
      return;
    }
    find(root.right,k);
  }
    public int kthSmallest(TreeNode root, int k) {
      if(root==null)return -1;
      find(root,k);
      return ks;
    }
}
