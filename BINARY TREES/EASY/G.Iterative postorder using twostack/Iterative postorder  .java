 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s=new Stack<TreeNode>();
      Stack<Integer> q=new Stack<Integer>();
      List<Integer> l=new LinkedList<Integer>();
      if(root==null)return l;
      s.push(root);
      while(!s.isEmpty()){
        TreeNode c=s.pop();
        q.push(c.val);
        if(c.left!=null)
         s.push(c.left);
        if(c.right!=null)
          s.push(c.right);
      }
      
      while(!q.isEmpty()){
        l.add(q.pop());
      }
      return l;
        
    }
}
