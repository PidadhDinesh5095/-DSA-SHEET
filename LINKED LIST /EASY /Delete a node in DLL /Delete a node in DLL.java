



/*

Definition for doubly Link List Node
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        if(head==null){
            return head;
        }
        if(x==1){
            return head.next;
        }
        Node temp=head;
        for(int i=2;i<x;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        if(temp.next!=null){
         temp.next.prev=temp;
        }
        return head;
    }
}
