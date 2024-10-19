/**Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.**/class MyStack {
   private  Queue<Integer> q;
    public MyStack() {
      q=new LinkedList<>();
    }
    
    public void push(int x) {
      q.add(x);
      for(int i=1;i<q.size();i++){
        q.add(q.peek());
        q.remove();
      }
      
    }
    
    public int pop() {
      if(!q.isEmpty()){
        return q.remove();
      }
      return 1;
    }
    
    public int top() {
      if(!q.isEmpty()){
        return q.peek();
      }
      return 1;
         
    }
    
    public boolean empty() {
        if(!q.isEmpty()){
          return false;
        }
        return true;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */