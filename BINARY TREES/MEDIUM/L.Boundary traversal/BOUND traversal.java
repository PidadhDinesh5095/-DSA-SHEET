class Solution {
    private List<Integer> d = new LinkedList<>();

    private void addLeftBoundary(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (!leafNode(curr)) d.add(curr.val);
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private boolean leafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void addRightBoundary(TreeNode root) {
        List<Integer> temp = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (!leafNode(curr)) temp.add(curr.val);
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            d.add(temp.get(i));
        }
    }

    private void addLeafs(TreeNode root) {
        if (leafNode(root)) {
            d.add(root.val);
            return;
        }
        addLeafs(root.left);
        addLeafs(root.right);
    }

    public List<Integer> boundaryTraversal(TreeNode root) {
        if (root == null) return d;
        if (!leafNode(root)) d.add(root.val);
        addLeftBoundary(root.left);
        addLeafs(root);
        addRightBoundary(root.right);
        return d;
    }
}
