

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

class GfG
{
    //Function to insert a new node at given position in doubly linked list.
    void addNode(Node head_ref, int pos, int data)
	{
		Node add=new Node(data);
		if(head_ref==null){
		    head_ref=add;
		}
		else{
		    Node temp=head_ref;
		    for(int i=0;i<pos && temp.next!=null;i++){
		        temp=temp.next;
		    }
		    add.next=temp.next;
		    add.prev=temp;
		    if(temp.next!=null){
		     temp.next.prev=add;
		    }
		    temp.next=add;
		}
	}
}
