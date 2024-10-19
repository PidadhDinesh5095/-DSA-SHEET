//You are given a string S of size N that represents the prefix form of a valid mathematical expression. The string S contains only lowercase and uppercase alphabets as operands and the operators are +, -, *, /, %, and ^.Convert it to its infix form.

// User function Template for Java

class Solution {
    private static String reverse(String o){
        StringBuilder r=new StringBuilder(o);
        return r.reverse().toString();
    }
    private static String modify(String o){
        char[] c=o.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='('){
                c[i]=')';
            }
            else if(c[i]==')'){
                c[i]='(';
            }
        }
        return new String(c);
    }
    
    static String preToInfix(String pre_exp) {
        pre_exp=reverse(modify(pre_exp));
        Stack<String> s=new Stack<>();
        for(int i=0;i<pre_exp.length();i++){
            char c=pre_exp.charAt(i);
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
        return reverse(modify(s.pop()));
    }
}
