
//Given a doubly linked list of n nodes sorted by values, the task is to remove duplicate nodes present in the linked list.
/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

Java

class Solution{
    Node removeDuplicates(Node head){
      if (head == null) return head;

        Node current = head;

        while (current.next != null) {
            if (current.data == current.next.data) {
                // Duplicate found, remove it
                Node duplicate = current.next;
                current.next = duplicate.next;
                if (duplicate.next != null) {
                    duplicate.next.prev = current;
                }
            } else {
                current = current.next;
            }
        }
        return head;
        
    }
}
