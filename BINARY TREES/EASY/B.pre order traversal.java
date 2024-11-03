//Given the root of a binary tree, return the preorder traversal of its nodes' values.

 class Solution {
      public List<Integer> preorderTraversal(TreeNode r) {
       List<Integer> l=new ArrayList<>();
      pt(r,l);
        return l;
        
    }
  private void pt(TreeNode r,List<Integer> l){
        if(r==null){
          return ;
        }
        l.add(r.val);
        pt(r.left,l);
        pt(r.right,l);
      }
 }
