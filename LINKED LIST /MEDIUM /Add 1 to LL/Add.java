//Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

//For example, the following two linked lists begin to intersect at node c1:
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
    private int add(Node temp){
        if(temp==null){
            return 1;
        }
        int v=add(temp.next);
        temp.data=temp.data +v;
        if(temp.data<10){
           return 0;
        }
        temp.data=0;
        return 1;
        
    }
    public Node addOne(Node head) {
        Node temp=head;
        int v=add(temp);
            if(v==1){
                Node New=new Node(1);
                New.next=head;
                return New;
            }
            else{
                return head;
            }
        
    }
}
