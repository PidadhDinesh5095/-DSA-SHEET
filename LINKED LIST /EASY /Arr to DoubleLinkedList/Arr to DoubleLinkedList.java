

// User function Template for Java

class Solution {
    Node constructDLL(int arr[]) {
        Node head=new Node(arr[0]);
        Node prev=head;
        for(int i=1;i<arr.length;i++){
            Node temp=new Node(arr[i]);
            prev.next=temp;
            temp.prev=prev;
            prev=temp;
        }
        return head;
        
    }
}
