//Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

//The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.class Solution {
    public int[] nextGreaterElements(int[] nums) {
      Stack<Integer> s=new Stack<>();
      int[] a=new int[nums.length];
      int l=nums.length;
      int i=l-2;
      while(i>=0){
        if(nums[i]>nums[l-1]){
          s.push(nums[i]);
        }
        i--;
      }
      if(!s.isEmpty()){
        a[l-1]=s.peek();
      }
     else{
        a[l-1]=-1;
      }
      s.push(nums[l-1]);
      for(int j=nums.length-2;j>=0;j--){
        int n=nums[j];
        while(!s.isEmpty() && s.peek()<=n){
          s.pop();
        }
        if(!s.isEmpty()){
          a[j]=s.peek();
        }
        else{
          a[j]=-1;
        }
        s.push(n);
      }
      return a;
    }
}
