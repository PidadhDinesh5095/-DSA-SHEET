//Given a binary tree having n nodes. Check whether all of its nodes have a value equal to the sum of their child nodes. Return 1 if all the nodes in the tree satisfy the given properties, else it returns 0. For every node, the data value must be equal to the sum of the data values in the left and right children. Consider the data value 0 for a NULL child. Also, leaves are considered to follow the property.
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
