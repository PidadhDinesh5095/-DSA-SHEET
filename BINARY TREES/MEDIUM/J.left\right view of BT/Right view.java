/*Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.*/
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
    public List<Integer> rightSideView(TreeNode root) {
        class set{
        TreeNode node;
        int x;
        set(TreeNode node,int x){
            this.node=node;
            this.x=x;
        }
    }

    // Function to return a list of nodes visible from the top view

    // from left to right in Binary Tree.

     
        List<Integer> l=new LinkedList<>();
        if(root==null)return l;
        TreeMap<Integer,TreeNode> m=new TreeMap<>();
        Queue<set> q=new LinkedList<>();
        q.offer(new set(root,0));
        while(!q.isEmpty()){
            TreeNode t=q.peek().node;
            int x=q.peek().x;
            q.remove();
            m.put(x,t);
            if(t.left!=null){
             q.offer(new set(t.left,x+1));
            }
            if(t.right!=null){
                q.offer(new set(t.right,x+1));
            }
        }
        for(TreeNode n : m.values()){
            l.add(n.val);
        }
        return l;
    }
}
