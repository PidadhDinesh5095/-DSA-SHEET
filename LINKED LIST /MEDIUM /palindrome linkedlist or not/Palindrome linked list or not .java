//Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  private ListNode reverse(ListNode r){
    ListNode next=null;
    ListNode prev=null;
    while(r!=null){
      next=r.next;
      r.next=prev;
      prev=r;
      r=next;
    }
    return prev;
  }
      
    public boolean isPalindrome(ListNode head) {
      if(head==null || head.next==null){
        return true;
      }
      
      ListNode s=head;
      ListNode f=head;
      while(f!=null && f.next!=null){
        s=s.next;
        f=f.next.next;
      }
      f=reverse(s);
      while(f!=null){
        if(f.val!=head.val){
          return false;
        }
        f=f.next;
        head=head.next;
      }
      return true;
      
        
    }
}
