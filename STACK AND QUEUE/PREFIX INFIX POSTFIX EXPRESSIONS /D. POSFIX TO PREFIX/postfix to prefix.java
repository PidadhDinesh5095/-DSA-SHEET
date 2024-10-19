//You are given a string that represents the postfix form of a valid mathematical expression. Convert it to its prefix form.

// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        Stack<String> s=new Stack<>();
        for(int i=0;i<post_exp.length();i++){
            char c=post_exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                s.push(String.valueOf(c));
            }
            else{
                String t1=s.pop();
                String t2=s.pop();
                String f=String.valueOf(c)+t2+t1;
                s.push(f);
            }
        }
        return s.pop();
    }
}
