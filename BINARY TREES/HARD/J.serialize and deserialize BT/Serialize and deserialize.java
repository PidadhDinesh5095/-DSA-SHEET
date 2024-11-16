/**Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 **/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      if(root==null)return "";
       Queue<TreeNode> q=new LinkedList<>();
      StringBuilder s=new StringBuilder();
      q.offer(root);
      while(!q.isEmpty()){
        TreeNode t=q.poll();
        if(t==null){
          s.append("n ");
          continue;
        }
        s.append(t.val+" ");
        q.offer(t.left);
        q.offer(t.right);
      }
      return s.toString();
    }

    
    public TreeNode deserialize(String data) {
        if(data=="")return null;
      String[] s=data.split(" ");
      Queue<TreeNode> q=new LinkedList<>();
         TreeNode root=new TreeNode(Integer.parseInt(s[0]));
      q.offer(root);
      int i=1;
      while(!q.isEmpty()){
        TreeNode t=q.poll();
        if(!s[i].equals("n")){
          TreeNode l=new TreeNode(Integer.parseInt(s[i]));
          t.left=l;
          q.offer(l);
        }
        i++;
        if(!s[i].equals("n")){
          TreeNode r=new TreeNode(Integer.parseInt(s[i]));
          t.right=r;
          q.offer(r);
        }
        i++;
      }
      return root;  
      
    }
}
