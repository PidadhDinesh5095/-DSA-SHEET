/**You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

 Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)return new TreeNode(val);
      TreeNode t=root;
      int a=0;
      while(true){
        if(t.val==val)return root;
        if(t.val<=val){
          if(t.right!=null){
            t=t.right;
            
          }
          else{
            t.right=new TreeNode(val);             break;
          }
        }
        else{
          if(t.left!=null){
            t=t.left;
            
          }
          else{
            t.left=new TreeNode(val);
            break;
          }
        }
      }

      return root;
    }
}
