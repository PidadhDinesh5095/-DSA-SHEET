/**You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.



Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.**/
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
public class Solution {

    private TreeNode first = null;

    private TreeNode second = null;

    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {

        traverse(root);

        if (first != null && second != null) {

            int temp = first.val;

            first.val = second.val;

            second.val = temp;

        }

    }

    private void traverse(TreeNode root) {

        if (root == null) return;

        traverse(root.left);

        if (first == null && prev.val > root.val) {

            first = prev;

        }

        if (first != null && prev.val > root.val) {

            second = root;

        }

        prev = root;

        traverse(root.right);

    }

}
