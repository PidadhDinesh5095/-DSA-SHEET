class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l=new LinkedList<Integer>();
      Stack<TreeNode> s=new Stack<TreeNode>();
      if(root==null)return l;
      TreeNode c=root;
      while(!s.isEmpty() || c!=null){
       if(c!=null){
         s.push(c);
         c=c.left;
       }
      else{
        TreeNode t=s.peek().right;
        if(t==null){
          t=s.pop();
          l.add(t.val);
          while(!s.isEmpty() && t==s.peek().right){
            t=s.pop();
            l.add(t.val);
          }
        }
        else{
         c=t;
        }
     } 
         
    }
    return l;
  }
}
