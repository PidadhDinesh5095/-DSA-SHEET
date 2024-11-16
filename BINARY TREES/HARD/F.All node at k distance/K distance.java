/*Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private List<Integer> l = new LinkedList<>();
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> tm) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t.left != null) {
                tm.put(t.left, t);
                q.offer(t.left);
            }
            if (t.right != null) {
                tm.put(t.right, t);
                q.offer(t.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> pm = new HashMap<>();

        if (root == null) return l;

        markParents(root, pm);

        Map<TreeNode, Boolean> v = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(target);

        v.put(target, true);

        while (!q.isEmpty()) {

            int s = q.size();

            if (k == 0) break;

            k--;

            for (int i = 0; i < s; i++) {

                TreeNode t = q.poll();

                if (t.left != null && v.get(t.left) == null) {

                    v.put(t.left, true);

                    q.offer(t.left);

                }

                if (t.right != null && v.get(t.right) == null) {
                    v.put(t.right, true);
                    q.offer(t.right);
                }
                if (pm.get(t) != null && v.get(pm.get(t)) == null) {
                
                    v.put(pm.get(t), true);
                    q.offer(pm.get(t));
                }
            }
        }
        while (!q.isEmpty()) {
            l.add(q.peek().val);
            q.poll();
        }  
      
        return l;
    }
}
