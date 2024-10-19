//You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key if it is present and return the new DLL.

// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}*/
class Solution {
    public Node deleteAllOccurOfX(Node head, int x) {
        if(head==null){
            return head;
        }
        Node dummy=new Node(0);
        dummy.next=head;
        head.prev=dummy;
        Node temp=head;
        while(temp!=null ){
            if(temp.data==x){
                temp.prev.next=temp.next;
                if(temp.next!=null){
                   temp.next.prev=temp.prev;
                }
            }
            temp=temp.next;
        }
        return dummy.next;
        
    }
}
