//Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogramclass Solution {
    public int largestRectangleArea(int[] heights) {
      Stack<Integer> s=new Stack<>();
      int m=0;
      for(int i=0;i<heights.length;i++){
        while(!s.isEmpty() && heights[s.peek()]>heights[i]){
          int e=heights[s.pop()];
          int pse=s.isEmpty() ? -1 : s.peek();
          m=Math.max(m,(i-pse-1)*e);
        }
        s.push(i);
      }
      while(!s.isEmpty()){
      int nse=heights.length;
       int e=heights[s.pop()];
      int pse=s.isEmpty() ? -1 : s.peek();
        m=Math.max(m,(nse-pse-1)*e);
      }
      return m;
    }
}
