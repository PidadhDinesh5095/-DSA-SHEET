class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l=new LinkedList<Integer>();
      Stack<TreeNode> s=new Stack<TreeNode>();
      if(root==null)return l;
      s.push(root);
      while(!s.isEmpty()){   
        TreeNode t=s.pop();
        l.add(t.val);
        if(t.right!=null)
          s.push(t.right);
        if(t.left!=null)
         s.push(t.left);
      }
      return l;
         
    }
}
