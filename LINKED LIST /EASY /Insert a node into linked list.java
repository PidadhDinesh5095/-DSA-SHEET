/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        if(head==null){
            Node current =new Node(x);
            return current;
        }
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=new Node(x);
        return head;
    }
}
