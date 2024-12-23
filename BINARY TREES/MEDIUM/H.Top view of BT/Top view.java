/**Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Return nodes from leftmost node to rightmost node. Also if 2 nodes are outside the shadow of the tree and are at same position then consider the left ones only(i.e. leftmost). 
For ex - 1 2 3 N 4 5 N 6 N 7 N 8 N 9 N N N N N will give 8 2 1 3 as answer. Here 8 and 9 are on the same position but 9 will get shadowed.*/
// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
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
     ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> l=new ArrayList<>();
        if(root==null)return l;
        TreeMap<Integer,Node> m=new TreeMap<>();
        Queue<set> q=new LinkedList<>();
        q.offer(new set(root,0));
        while(!q.isEmpty()){
            Node t=q.peek().node;
            int x=q.peek().x;
            q.remove();
            if(!m.containsKey(x)){
                m.put(x,t);
            }
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
