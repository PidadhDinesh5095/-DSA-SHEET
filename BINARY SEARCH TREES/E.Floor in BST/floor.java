/**You are given a BST(Binary Search Tree) with n number of nodes and value x. your task is to find the greatest value node of the BST which is smaller than or equal to x.
Note: when x is smaller than the smallest node of BST then returns -1.
  Input:
n = 7               2
                     \
                      81
                    /     \
                 42       87
                   \       \
                    66      90
                   /
                 45
x = 87
Output:
87
Explanation:
87 is present in tree so floor will be 87.
  Input:
n = 4                     6
                           \
                            8
                          /   \
                        7       9
x = 11
Output:
9**/
  

// User function Template for Java

class Solution {
    public static int floor(Node root, int x) {
        if(root==null)return -1;
        int a=-1;
        while(root!=null){
            if(root.data==x)return x;
            if(root.data>x){
                root=root.left;
            }else{
                a=root.data;
                root=root.right;
            }
        }
        return a;
    }
}
