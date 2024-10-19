/**Implement a Queue using Linked List. 
A Query Q is of 2 Types
(i) 1 x   (a query of this type means  pushing 'x' into the queue)
(ii) 2     (a query of this type means to pop an element from the queue and print the poped element)**/

/*The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}*/

class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a)
	{
	    QueueNode temp=new QueueNode(a);
        if(front==null){
            front=rear=temp;
        }
        else{
            rear.next=temp;
            rear=temp;
        }
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
	    if(front==null){
	        return -1;
	    }
        int e=front.data;
        front=front.next;
        return e;
	}
}


