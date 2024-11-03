 
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int lh=height(root.left);
        int rh=height(root.right);
        if(Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right)){
          return true;
        }
      return false;
      
    }
  private int height(TreeNode r){
    if(r==null)return 0;
    int lh=height(r.left);
    int rh=height(r.right);
    return 1+Math.max(lh,rh);
  }
}
