/**You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.**/class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1,w=0,h=0,t=0;
      while(l<r){
        w=r-l;
       h=Math.min(height[l],height[r]);
       t=Math.max(t,w*h);
       if(height[l]<height[r]){
         l++;
        }
        else{
          r--;
        }
      }
      return t;
        
    }
}
