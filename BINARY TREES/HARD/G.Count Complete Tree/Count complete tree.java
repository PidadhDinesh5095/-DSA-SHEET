/*Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.*/
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
    public int countNodes(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
      if(root==null) return 0;
      q.offer(root);
      int k=0;
      while(!q.isEmpty()){
        
        int len=q.size();
        k=k+len;
        
        for(int i=0;i<len;i++){
          TreeNode t=q.poll();
          if(t.left!=null)
            q.offer(t.left);
          if(t.right!=null)
            q.offer(t.right);
        }        
      }
      return k;
    }
}
  
