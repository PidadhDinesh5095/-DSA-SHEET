//Given an array of N integers and Q queries of indices. Return a list NGEs[] where NGEs[i] stores the count of elements strictly greater than the current element (arr[indices[i]]) to the right of indices[i].

//User function Template for Java

class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    int[] greaterCount = new int[N];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> s=new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                s.push(stack.pop());
            }
            
            greaterCount[i] = stack.size();
            stack.push(arr[i]);
            while (!s.isEmpty()) {
                stack.push(s.pop());
            }
        }
        
        int[] result = new int[queries];
        for (int q = 0; q < queries; q++) {
            result[q] = greaterCount[indices[q]];
        }
        
        return result;
     
  }
}
     
     
