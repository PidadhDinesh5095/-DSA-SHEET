/*Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.*/
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
    public void flatten(TreeNode root) {
      if(root==null)return ;
      Stack<TreeNode> s=new Stack<>();
      s.push(root);
      while(!s.isEmpty()){
        TreeNode t=s.pop();
    if(t.right!=null)s.push(t.right);
        if(t.left!=null)s.push(t.left);
       if(!s.isEmpty()){
         t.right=s.peek();
        }
        t.left=null;
      }
      return ;
    }
}
