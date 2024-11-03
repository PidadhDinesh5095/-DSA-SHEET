class Solution {
    public List<Integer> inorderTraversal(TreeNode r) {
        List<Integer> l=new ArrayList<>();
      pt(r,l);
        return l;
    }
  private void pt(TreeNode r,List<Integer> l){
        if(r==null){
          return ;
        }
        
        pt(r.left,l);
        l.add(r.val);
        pt(r.right,l);
        
      }

}
    
