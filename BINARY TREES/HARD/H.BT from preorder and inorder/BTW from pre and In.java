//Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
/**
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {

            m.put(inorder[i], i);

        }

        TreeNode root = builder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, m);

        return root;

    }

    private TreeNode builder(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, Map<Integer, Integer> m) {

        if (prestart > preend || instart > inend) return null;

        TreeNode root = new TreeNode(preorder[prestart]);

        int inroot = m.get(root.val);

        int nleft = inroot - instart;

        root.left = builder(preorder, prestart + 1, prestart + nleft, inorder, instart, inroot - 1, m);

        root.right = builder(preorder, prestart + nleft + 1, preend, inorder, inroot + 1, inend, m);

        return root;

    }

}
