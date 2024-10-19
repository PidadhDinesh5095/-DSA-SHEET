/**Given an infix expression in the form of string str. Convert this infix expression to postfix expression.

Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. Ignore the right associativity of ^.**/

class Solution {
    private static int prec(char ch){
        switch(ch){
            case '+' :
            case '-' :
                return 1;
            case '*' :
            case '/' :
                return 2;
            case '^' : 
              return 3;  
            
        }
        return -1;
    }
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
      Stack<Character> s=new Stack<>();
       String a=new String("");
       for(int i=0;i<exp.length();++i){
           char k=exp.charAt(i);
           if(Character.isLetterOrDigit(k)){
               a=a+k;   
              }
              else if(k=='('){
                  s.push(k);
              }
              else if(k==')'){
                  while(!s.isEmpty() && s.peek()!='('){
                      a=a+s.pop();
                  }
                  if(!s.isEmpty()){
                    s.pop();
                  }
              }
              else{
                  while(!s.isEmpty() && prec(k)<= prec(s.peek())){
                      a=a+s.pop();
                  }
                  s.push(k);
              }
             
        }
        while(!s.isEmpty()){
            a=a+s.pop();
        }
              
       
       return a;
    }
}
