//Given a Binary Tree of nodes, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    ArrayList<ArrayList<Integer>> l=new ArrayList<>();
    ArrayList<Integer> sl=new ArrayList<>();
    private void findpath(Node root){
          if(root==null)return ;
           sl.add(root.data);
          if(root.left==null && root.right==null){
              l.add(new ArrayList<>(sl));
          }
          else{
              findpath(root.left);
              findpath(root.right);
          }
          sl.remove(sl.size()-1);
    }
    public  ArrayList<ArrayList<Integer>> Paths(Node root) {
      if(root==null)return l;
      findpath(root);
      return l;
    }
}
        
