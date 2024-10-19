/**Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.**/
/**
 * DefiniDefinitiontion for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 */
class Solution {
  public ListNode reverse(ListNode r){
    ListNode prev=null;
    ListNode next=null;
    while(r!=null){
      next=r.next;
      r.next=prev;
      prev=r;
      r=next;
    }
    return prev;
  }
    public ListNode reverseKGroup(ListNode head, int k) {
      if(head==null || k==1){
        return head;
      }
      int K=k;
      ListNode ans=new ListNode(0);
      ListNode ansTemp=ans;
      ListNode curr=head.next;
      ListNode prev=head;
      ListNode r=head;
     ListNode temp=null;
      while(prev!=null ){
        for(int i=0;i<k-1 && curr!=null;i++){
          curr=curr.next;
          prev=prev.next;
          K--;
         }
        if(K==1){
           prev.next=null;
           ansTemp.next=reverse(r);
           ansTemp=r;
           r=curr;
           prev=curr;
           if(prev!=null){
              curr=curr.next;
           }
        }
        else{
          ansTemp.next=r;
          prev=curr;
          if(prev!=null){
            curr=curr.next;
          }
        
        }
        K=k;  
      }
      return ans.next;
    }
}
