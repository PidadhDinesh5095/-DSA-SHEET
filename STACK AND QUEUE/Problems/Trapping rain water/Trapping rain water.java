//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.class Solution {
    public int trap(int[] height) {
       int lm=0,rm=0,t=0,l=0;
      int r=height.length-1;
      while(l<r){
        if(height[l]<=height[r]){
          if(lm>height[l]){
            t+=lm-height[l];
          }
          else{
            lm=height[l];
          }
          l++;
        }
        else{
          if(rm>height[r]){
            t+=rm-height[r];
          }
          else{
            rm=height[r];
          }
          r--;
        }
        
      }
      return t;
          
        
    }
}
