//Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.

 

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

class Solution {
    private static Node tail(Node temp){
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
       ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
       if(head==null){
           return ans;
       }
       Node left=head;
       Node right=tail(head);
       while(left.data<right.data){
           if(left.data+right.data==target){
               ArrayList<Integer> p=new ArrayList<>();
               p.add(left.data);
               p.add(right.data);
               ans.add(p);
               left=left.next;
               right=right.prev;
           }
           else if(left.data+right.data<target){
               left=left.next;
           }
           else{
               right=right.prev;
           }
       }
       return ans;
    }
}
        
