//Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.class Solution {
  private int largestRectangleArea(int[] heights) {
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
    public int maximalRectangle(char[][] m) {
      int[][] ps=new int[m.length][m[0].length];
      int n=m.length;
      int o=m[0].length;
      for(int i=0;i<o;i++){
        int sum=0;
        for(int j=0;j<n;j++){
          if(m[j][i]=='0'){
            sum=0;
          }
          else{
            sum++;
          }
          ps[j][i]=sum;
         
      }
      }
      int t=0;
      for(int[] i: ps){
        t=Math.max(t,largestRectangleArea(i));
        
      }
      return t;
    }
}
