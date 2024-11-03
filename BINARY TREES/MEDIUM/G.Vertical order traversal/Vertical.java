/**
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree
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
  class set{
    TreeNode node;
    int row,col;
    set(TreeNode root,int row,int col){
      this.node=root;
      this.row=row;
      this.col=col;
    }
  }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> l=new ArrayList<>();
      if(root==null)return l;
      TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> tm=new TreeMap<>();
      Queue<set> q=new LinkedList<set>();
      q.offer(new set(root,0,0));
      while(!q.isEmpty()){
        set temp=q.poll();
        TreeNode t=temp.node;
        int x=temp.row;
        int y=temp.col;
        if(!tm.containsKey(x)){
          tm.put(x,new TreeMap<>());
        }
        if(!tm.get(x).containsKey(y)){
          tm.get(x).put(y, new PriorityQueue<>());
        }
        tm.get(x).get(y).offer(t.val);
        if(t.left!=null){
          q.offer(new set(t.left,x-1,y+1));
        }
        if(t.right!=null){
          q.offer(new set(t.right,x+1,y+1));
        }
      }
      for(TreeMap<Integer,PriorityQueue<Integer>> ym : tm.values()){
      List<Integer> sub=new ArrayList<>();
        for(PriorityQueue<Integer> p: ym.values()){      
          while(!p.isEmpty()){
             sub.add(p.poll());    
          }
        }
        l.add(sub);
      
      }
      return l;  
    }
}
