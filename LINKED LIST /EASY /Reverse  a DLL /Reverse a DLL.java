/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

*/
public static Node reverseDLL(Node  head)
{
    if(head==null || head.next==null){
        return head;
    }
    Node current=head;
    Node temp=null;
    while(current!=null){
        temp=current.prev;
        current.prev=current.next;
        current.next=temp;
        current=current.prev;
    }
    return temp.prev;
    
    

}
