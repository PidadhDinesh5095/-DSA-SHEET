



/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        if(root==null)return 0;
        Node t=root;
        while(t.left!=null){
             t=t.left;
        }
        return t.data;
    }
}
