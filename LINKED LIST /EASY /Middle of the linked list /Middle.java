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
    public ListNode middleNode(ListNode head) {
      int c=0;
      ListNode temp=head;
      while(temp!=null){
        temp=temp.next;
        c++;
      }
       temp=head;
      c=(c/2);
      while(c!=0){
        temp=temp.next;
        c--; 
      }
      return temp;
    }
}
