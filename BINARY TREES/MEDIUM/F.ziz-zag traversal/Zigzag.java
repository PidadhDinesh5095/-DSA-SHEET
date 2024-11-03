/**
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l=new LinkedList<List<Integer>>();
      Queue<TreeNode> q=new LinkedList<TreeNode>();
      if(root==null) return l;
      q.offer(root);
      int flag=0;
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
        if(flag==1){
          Collections.reverse(sublist);
          flag=0;
        }
        else{
          flag=1;
        }
        l.add(sublist);
      }
      return l;
    }
}

