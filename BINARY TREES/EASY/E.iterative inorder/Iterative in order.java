class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> l=new LinkedList<Integer>();
      if(root==null) return l;
      Stack<TreeNode> s=new Stack<TreeNode>();
      while(true){
        if(root!=null){
          s.push(root);
          root=root.left;
        }
        else{
          if(s.isEmpty()) break;
          root=s.pop();
          l.add(root.val);
          root=root.right;
        }
      }
      return l;
    }
}
