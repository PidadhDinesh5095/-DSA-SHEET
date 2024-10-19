/**Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.**/class Solution {
  private Stack<Character> S;
    public boolean isValid(String s) {
        S=new Stack<>();
      for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        if(c=='(' || c=='{' || c=='['){
          S.push(c);
        }
        else{
          if(S.isEmpty()){
            return false;
          }
        
        char t=S.peek();
        if(c==')' && t=='(' ||
           c==']' && t=='[' ||
           c=='}' && t=='{'){
          S.pop();
        }
        else{
          return false;
        }
      }
      }
      return S.isEmpty();
    }
}
