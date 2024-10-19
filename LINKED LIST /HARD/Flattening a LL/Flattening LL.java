/*Given a Linked List, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked lists is in sorted order.
Flatten the Link List so all the nodes appear in a single level while maintaining the sorted order.

Note: The flattened list will be printed using the bottom pointer instead of the next pointer. Look at the printList() function in the driver code for more clarity.**/// User function Template for Java

class Solution {
    private Node merge(Node t1,Node t2){
        Node d=new Node(0);
        Node ans=d;
        while(t2!=null && t1!=null){
            if(t1.data < t2.data){
                ans.bottom=t1;
                ans=t1;
                t1=t1.bottom;
            }
            else{
                ans.bottom=t2;
                ans=t2;
                t2=t2.bottom;
            }
            ans.next=null;
        }
        if(t1!=null){
            ans.bottom=t1;
        }
        else{
            ans.bottom=t2;
        }
        if(d.bottom!=null){
            d.bottom.next=null;
        }
        return d.bottom;
    }
    // Function to flatten a linked list
    Node flatten(Node root) {
        if(root==null || root.next==null){
            return root;
        }
        Node t2=flatten(root.next);
        root=merge(root,t2);
        return root;
    }
}
