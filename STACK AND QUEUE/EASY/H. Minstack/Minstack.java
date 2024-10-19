/**
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.**/
class MinStack {

      private Stack<Integer> S;

    private Stack<Integer> minStack;

    public MinStack() {

        S = new Stack<>();

        minStack = new Stack<>();
        
    }
    
    public void push(int val) {
      S.push(val);
      if (minStack.isEmpty() || val <= minStack.peek()) {

            minStack.push(val);

        }
        
    }
    
    public void pop() {
      if (S.isEmpty()) {

            return;
      }
        if (S.peek().equals(minStack.peek())) {

            minStack.pop();

        }

        S.pop();
        
    }
    
    public int top() {
      if (S.isEmpty()) {

            return -1;
      }
        return S.peek();
    }
    
    public int getMin() {
          if (minStack.isEmpty()) {

            return -1;

        }

        return minStack.peek();

    }
        
    }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
