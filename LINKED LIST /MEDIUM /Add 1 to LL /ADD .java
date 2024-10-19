//You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

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
