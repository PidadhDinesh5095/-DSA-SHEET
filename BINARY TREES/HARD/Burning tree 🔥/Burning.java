

/**User function Template for Java
Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.
Note: The tree contains unique values.*//

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    private void markParents(Node root, Map<Node,Node> tm) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node t = q.poll();
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
    private Node search(int t,Node r){
        if(r==null)return null;
        if(r.data==t)return r;
       Node l= search(t,r.left);
       if(l!=null)return l;
       return  search(t,r.right);
    }
    public  int minTime(Node root, int target) 
    {
        
    Map<Node, Node> pm = new HashMap<>();
        if (root == null) return 0;
        markParents(root, pm);
        Map<Node, Boolean> v = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
       Node T=search(target,root);
       if(T==null)return 0;
        q.offer(T);
        v.put(T, true);
        int k=0;
    
        while (!q.isEmpty()) {
            boolean b=false;
            int s = q.size();
            
            for (int i = 0; i < s; i++) {
                Node t = q.poll();
                if (t.left != null && v.get(t.left) == null) {
                    v.put(t.left, true);
                    q.offer(t.left);
                    b=true;
                }
                if (t.right != null && v.get(t.right) == null) {
                    v.put(t.right, true);
                    q.offer(t.right);
                    b=true;
                }
                if (pm.get(t) != null && v.get(pm.get(t)) == null) {
                    v.put(pm.get(t), true);
                    q.offer(pm.get(t));
                    b=true;
                }
            }
            if(b)k++;
            
        }
        return k;
    }
}
