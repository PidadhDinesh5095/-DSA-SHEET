/**The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.**/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      Stack<Integer> s=new Stack<>();
      HashMap<Integer,Integer> m=new HashMap<>();
      for(int i=nums2.length-1;i>=0;i--){
        int n=nums2[i];
        while(!s.isEmpty() && s.peek()<=n){
          s.pop();
        }
        if(!s.isEmpty()){
          m.put(n,s.peek());
        }
        else{
          m.put(n,-1);
        }
        s.push(n);
      }
      int[] a=new int[nums1.length];
      for(int i=0;i<nums1.length;i++){
        a[i]=m.get(nums1[i]);
      }
      return a;
    }
}
