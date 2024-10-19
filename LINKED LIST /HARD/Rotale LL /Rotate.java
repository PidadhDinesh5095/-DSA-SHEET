//Given the head of a linked list, rotate the list to the right by k places.
 /** Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  private int len(ListNode temp){
    int l=0;
    while(temp!=null){
      temp=temp.next;
      l++;
    }
    return l;
  }
    public ListNode rotateRight(ListNode head, int k) {
      if(head==null || k==0 ||head.next==null){
        return head;
      }
      int l=len(head);
      if(k%l==0){
        return head;
      }
      k=k%l;
      ListNode prev=head;
      ListNode curr=head;
      while(k>0){
        curr=curr.next;
        k--;
      }
      while(curr.next!=null){
          curr=curr.next;
        prev=prev.next;   
      }
      ListNode temp=prev.next;
      prev.next=null;
      curr.next=head;
      return temp;
      
     } 
 }
