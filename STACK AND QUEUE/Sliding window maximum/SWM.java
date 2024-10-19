//You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

//Return the max sliding window.
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
     int[] ans=new int[nums.length-k+1];
      int x=0;
      Deque<Integer> dq=new LinkedList<>();
      for(int i=0;i<nums.length;i++){
        if(!dq.isEmpty() && dq.getFirst()<=i-k){
          dq.removeFirst();
        }
        while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]){
          dq.removeLast();
        }
        dq.addLast(i);
        if(i>=k-1){
          ans[x]=nums[dq.getFirst()];
          x++;
        }
      }
      return ans;
      
    }
}
