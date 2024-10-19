//You are given a string that represents the prefix form of a valid mathematical expression. Convert it to its postfix form.

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
    static String preToPost(String pre_exp) {
        Stack<String> s=new Stack<>();
        pre_exp=reverse(modify(pre_exp));
        for(int i=0;i<pre_exp.length();i++){
            char c=pre_exp.charAt(i);
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
        return reverse(modify(s.pop()));
    }
}
