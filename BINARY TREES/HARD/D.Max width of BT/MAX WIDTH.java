/*Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.*/
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
    public int widthOfBinaryTree(TreeNode root) {
      if(root==null)return 0;
      Deque<Pair<TreeNode,Integer>> q=new LinkedList<>();
      
      int ans=0;
      q.offer(new Pair<>(root,0));
      
      while(!q.isEmpty()){
        int f=q.getFirst().getValue();
        int l=q.getLast().getValue();
        int y=q.size();
        for(int i=0;i<y;i++){
          TreeNode t= q.peek().getKey();
          int p=q.peek().getValue()-f;
          q.poll();
          if(t.left!=null){
            
            q.offer(new Pair<>(t.left,2*p));
            }
            
            
          if(t.right!=null){
             q.offer(new Pair<>(t.right,2*p+1));
          }
            
          
        }
         
        ans=Math.max(ans,(l-f)+1);
       }
       return ans;   
    }
}
