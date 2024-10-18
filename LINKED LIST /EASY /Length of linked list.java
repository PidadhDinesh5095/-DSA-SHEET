/*Complete the function below*/
/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        Node current=head;
        int c=1;
        while(current.next!=null){
            c++;
            current=current.next;
            
        }
        return c;
    }
}
