class Solution {
    public List<Integer> postorderTraversal(TreeNode r) {
        List<Integer> l=new ArrayList<>();

      pt(r,l);
        return l;
    }
  private void pt(TreeNode r,List<Integer> l){
        if(r==null){
          return ;
        }
        pt(r.left,l);
        pt(r.right,l);
        l.add(r.val);
      }

}
  
