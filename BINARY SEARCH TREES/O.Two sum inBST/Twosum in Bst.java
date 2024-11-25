/**Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

 




Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
  **/
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
 class solution{
    private Stack<TreeNode> forwardStack = new Stack<>();

    private Stack<TreeNode> backwardStack = new Stack<>();

    // Push all left nodes for forward traversal

    private void pushLeft(TreeNode node) {

        while (node != null) {

            forwardStack.push(node);

            node = node.left;

        }

    }

    // Push all right nodes for backward traversal

    private void pushRight(TreeNode node) {

        while (node != null) {

            backwardStack.push(node);

            node = node.right;

        }

    }

    // Constructor to initialize iterators

    private solution(TreeNode root) {

        pushLeft(root);

        pushRight(root);

    }

    private int next() {

        if (!hasNext()) return -1;

        TreeNode node = forwardStack.pop();

        pushLeft(node.right);

        return node.val;

    }

    private int prev() {

        if (!hasPrev()) return -1;

        TreeNode node = backwardStack.pop();

        pushRight(node.left);

        return node.val;

    }

    private boolean hasNext() {

        return !forwardStack.isEmpty();

    }

    private boolean hasPrev() {

        return !backwardStack.isEmpty();

    }
   }

    public boolean findTarget(TreeNode root, int k) {

        if (root == null) return false;

        // Initialize the BST iterators

        solution iterator = new solution(root);

        int left = iterator.next();

        int right = iterator.prev();

        while (left < right) {

            if (left + right == k) return true;

            if (left + right < k) left = iterator.next();

            else right = iterator.prev();

        }

        return false;

    }

}
