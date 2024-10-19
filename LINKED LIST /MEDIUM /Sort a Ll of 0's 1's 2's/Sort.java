//Given a linked list where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to the head side, 2s at the end of the linked list, and 1s in the middle of 0s and 2s.// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        Node z=new Node(0);
        Node ztemp=z;
        Node o=new Node(1);
        Node otemp=o;
        Node t=new Node(2);
        Node ttemp=t;
        while(head!=null){
            if(head.data==0){
                ztemp.next=head;
                ztemp=ztemp.next;
            }
            else if(head.data==1){
                otemp.next=head;
                otemp=otemp.next;
            }
            else{
                ttemp.next=head;
                ttemp=ttemp.next;
            }
            head=head.next;
        }
        if(z.next==null){
            if(o.next==null){
                ttemp.next=null;
                return t.next;
            }
            else{
                otemp.next=t.next;
                ttemp.next=null;
                return o.next;
            }
        }
        else{
            if(o.next==null){
                ztemp.next=t.next;
                ttemp.next=null;
                return z.next;
            }
            else{
                ztemp.next=o.next;
                otemp.next=t.next;
                ttemp.next=null;
                return z.next;
            }
        }
        
    }
}
