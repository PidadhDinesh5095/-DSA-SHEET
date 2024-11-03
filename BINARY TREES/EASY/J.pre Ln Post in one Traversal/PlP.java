

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
class Tree {
    ArrayList<Integer> postOrder(Node root) {
       ArrayList<Integer> l=new ArrayList<Integer>();
      Stack<Node> s=new Stack<Node>();
      if(root==null)return l;
      Node c=root;
      while(!s.isEmpty() || c!=null){
       if(c!=null){
         s.push(c);
         c=c.left;
       }
      else{
        Node t=s.peek().right;
        if(t==null){
          t=s.pop();
          l.add(t.data);
          while(!s.isEmpty() && t==s.peek().right){
            t=s.pop();
            l.add(t.data);
          }
        }
        else{
         c=t;
        }
     } 
         
    }
    return l;
    }
}
