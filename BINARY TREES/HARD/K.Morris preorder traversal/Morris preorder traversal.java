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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l=new LinkedList<>();
      TreeNode curr=root;
      while(curr!=null){
        if(curr.left==null){
          l.add(curr.val);
          curr=curr.right;
        }
        else{
           TreeNode t=curr.left;
          while(t.right!=null && t.right!=curr){
            t=t.right;
          }
          if(t.right==null){
            t.right=curr;
          
            curr=curr.left;
          }
          else{
            t.right=null;
            l.add(curr.val);
            curr=curr.right;
          }
        }
      }
        return l;
    }
}
