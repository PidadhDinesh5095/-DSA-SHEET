/** Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.**/class MyQueue {
  Stack<Integer> s,t;
    public MyQueue() {
        s=new Stack<>();
        t=new Stack<>();
    }
    
    public void push(int x) {
        s.push(x);
    }
    
    public int pop() {
      if(t.isEmpty()){
        while(!s.isEmpty()){
          t.push(s.pop());
        }
      }
      return t.pop();
    }
    
    public int peek() {
      if(t.isEmpty()){
        while(!s.isEmpty()){
          t.push(s.pop());
        }
      }
      return t.peek();
    }
    
    public boolean empty() {
      
     return s.isEmpty() && t.isEmpty();
        
          
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
