//Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {

            m.put(inorder[i], i);

        }

        return builder(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, m);

    }

    private TreeNode builder(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> m) {

        if (postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = m.get(root.val);

        int nLeft = inRoot - inStart;

        root.left = builder(postorder, postStart, postStart + nLeft - 1, inorder, inStart, inRoot - 1, m);

        root.right = builder(postorder, postStart + nLeft, postEnd - 1, inorder, inRoot + 1, inEnd, m);

        return root;

    }

}
