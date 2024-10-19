//You are given a string that represents the postfix form of a valid mathematical expression. Convert it to its infix form.You are given a string that represents the postfix form of a valid mathematical expression. Convert it to its infix form.
class Solution {
    static String postToInfix(String exp) {
        Stack<String> s=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                s.push(String.valueOf(c));
            }
            else{
                String t1=s.pop();
                String t2=s.pop();
                String f="("+t2+String.valueOf(c)+t1+")";
                s.push(f);
            }
        }
        return s.pop();
    }
}
