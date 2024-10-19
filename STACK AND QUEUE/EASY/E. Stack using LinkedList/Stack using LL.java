/**Let's give it a try! You have a linked list and must implement the functionalities push and pop of stack using this given linked list. Your task is to use the class as shown in the comments in the code editor and complete the functions push() and pop() to implement a stack. 
The push() method takes one argument, an integer 'x' to be pushed into the stack and pop() which returns an integer present at the top and popped out from the stack. If the stack is empty then return -1 from the pop() method.
Note: The input is given in the form of queries. Since there are two operations push() and pop(), there is two types of queries as described below:
(i) 1   (a query of this type takes x as another parameter and pushes it into the stack)
(ii) 2  (a query of this type means to pop an element from the stack and return the popped element)
Input is separated by space and as described above**/

class MyStack {
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }
    StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        StackNode temp=new StackNode(a);
        temp.next=top;
        top=temp;
    }

    // Function to remove an item from top of the stack.
    int pop() {
        if(top==null){
            return -1;
        }
        int e=top.data;
        top=top.next;
        return e;
    }
}
