//Given the head of a linked list, return the list after sorting it in ascending order.

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
    public ListNode sortList(ListNode head) {
      if(head==null || head.next==null){
        return head;
      }
      ListNode s=head;
      ListNode f=head.next;
      while(f!=null && f.next!=null){
        s=s.next;
        f=f.next.next;
      }
      ListNode m=s.next;
      s.next=null;
      ListNode left=sortList(head);
      ListNode right=sortList(m);
      return merge(left,right);  
    }
  private ListNode merge(ListNode l,ListNode r){
    ListNode d=new ListNode(0);
    ListNode temp=d;
    while(l!=null && r!=null){
      if(l.val>r.val){
        temp.next=r;
        r=r.next;
      }
      else{
        temp.next=l;
        l=l.next;
      }
      temp=temp.next;
    }
      if(r!=null){
        temp.next=r;
      }
      else{
        temp.next=l;
      }
    return d.next;
  }
}
