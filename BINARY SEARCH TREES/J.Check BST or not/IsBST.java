/**Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.**/
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

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);

    }

    private boolean isValidBST(TreeNode node, Integer lower, Integer upper){
        if (node == null){
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower){
            return false;
        }
        if (upper != null && val >= upper){
            return false;
        }
        if (!isValidBST(node.right, val, upper)){
            return false;
        }
        if (!isValidBST(node.left, lower, val)) {
            return false;
        }
        return true;
    }
 }
