//Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()){
          return "0";
        }
      Stack<Character> s=new Stack<>();
      int t=k;
      for(char i:num.toCharArray()){
        while(!s.isEmpty() && t>0 && s.peek()>i){
          s.pop();
          t--;
        }
        s.push(i);
      }
      while(t>0){
        s.pop();
        t--;
      }
     StringBuilder r=new StringBuilder();
       while(!s.isEmpty()){
         r.append(s.pop());
      }
      r.reverse(); 
      while(r.length()>1 &&  r.charAt(0)=='0'){
        r.deleteCharAt(0);
      }
      return r.toString();
      
    }
}
