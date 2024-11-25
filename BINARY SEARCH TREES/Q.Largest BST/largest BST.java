/**You're given a binary tree. Your task is to find the size of the largest subtree within this binary tree that also satisfies the properties of a Binary Search Tree (BST). The size of a subtree is defined as the number of nodes it contains.

Note: A subtree of the binary tree is considered a BST if for every node in that subtree, the left child is less than the node, and the right child is greater than the node, without any duplicate values in the subtree.



Input: root = [5, 2, 4, 1, 3]
Root-to-leaf-path-sum-equal-to-a-given-number-copy
Output: 3
Explanation:The following sub-tree is a BST of size 3
  **/
class Solution {
    class Node {
        int max, min, size;
        Node(int max, int min, int size) {
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
    
    public int largestBST(TreeNode root) {
        return largest(root).size;
    }

    private Node largest(TreeNode root) {
        if (root == null) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Node l = largest(root.left);
        Node r = largest(root.right);
        if (l.max < root.val && r.min > root.val) {
            return new Node(r.max, l.min, r.size + l.size + 1);
        }
        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(r.size, l.size));
    }
}
