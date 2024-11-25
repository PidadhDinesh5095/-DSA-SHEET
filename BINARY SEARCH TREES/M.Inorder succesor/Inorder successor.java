class Solution {
    public int successorinBST(TreeNode root, int k) {
        int s = -1;
        while (root != null) {
            if (k >= root.val) {
                root = root.right;
            } else {
                s = root.val;
                root = root.left;
            }
        }
        return s;
    }
}
