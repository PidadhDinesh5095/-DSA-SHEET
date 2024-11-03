/**Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.**/
class Solution {
    public int maxDepth(TreeNode root) {
        int l=0;
      Queue<TreeNode> q=new LinkedList<TreeNode>();

      if(root==null) return 0;
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
        l++;
      }
      return l;      
    }
}
