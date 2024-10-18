

// User function Template for Java

/*
class Node {
    int data;
    Node next;

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
}
*/
class Solution {
    static Node constructLL(int arr[]) {
        if(arr==null){
            return null;
        }
        Node head=new Node(arr[0]);
        Node current=head;
        for(int i=1;i<arr.length;i++){
            current.next=new Node(arr[i]);
            current=current.next;
        }
        return head;
    }
}
