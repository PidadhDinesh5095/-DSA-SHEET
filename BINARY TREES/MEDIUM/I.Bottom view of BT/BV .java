/*Given a binary tree, return an array where elements represent the bottom view of the binary tree from left to right.

Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level traversal is considered. For example, in the below diagram, 3 and 4 are both the bottommost nodes at a horizontal distance of 0, here 4 will be considered.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree, the output should be 5 10 4 14 25.*/


//User function Template for Java


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    class set{
        Node node;
        int x;
        set(Node node,int x){
            this.node=node;
            this.x=x;
        }
    }
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
     ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> l=new ArrayList<>();
        if(root==null)return l;
        TreeMap<Integer,Node> m=new TreeMap<>();
        Queue<set> q=new LinkedList<>();
        q.offer(new set(root,0));
        while(!q.isEmpty()){
            Node t=q.peek().node;
            int x=q.peek().x;
            q.remove();
            m.put(x,t);
            if(t.left!=null){
                q.offer(new set(t.left,x-1)); 
            }
            if(t.right!=null){
                q.offer(new set(t.right,x+1));
            }
        }
        for(Node n : m.values()){
            l.add(n.data);
        }
        return l;
     }
}
