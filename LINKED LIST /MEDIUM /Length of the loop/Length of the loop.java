

/*

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

// Function should return the length of the loop in LL.

class Solution {


    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        if(head==null){
            return 0;
        }
        
        Node s=head;
        Node f=head;
        while(f!=null && f.next!=null){
            int c=1;
            s=s.next;
            f=f.next.next;
            if(s==f){
                 f=f.next;
                 while(f!=s){
                     c++;
                     f=f.next;
                 }
                 return c;
            }
            
        }
         return 0;
    }
}
