class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l=new LinkedList<List<Integer>>();
      Queue<TreeNode> q=new LinkedList<TreeNode>();
      if(root==null) return l;
      q.offer(root);
      while(!q.isEmpty()){
        List<Integer> sublist=new LinkedList<Integer>();
        int len=q.size();
        for(int i=0;i<len;i++){
          if(q.peek().left!=null)
            q.offer(q.peek().left);
          if(q.peek().right!=null)
            q.offer(q.peek().right);
        
          sublist.add(q.poll().val);
        }
        l.add(sublist);
      }
      return l;
      
    }
}
