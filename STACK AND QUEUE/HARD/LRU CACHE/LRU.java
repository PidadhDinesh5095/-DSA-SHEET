/**
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.**/class LRUCache {
    class node{
      int key;
      int val;
      node next,prev;
      node(int key,int val){
        this.key=key;
        this.val=val;
        this.next=null;
        this.prev=null;
      }
    }
    private Map<Integer,node> m;
    private int c;
    private int s;
    private node head;
    private node tail;
    private void removeNode(node temp){
      temp.prev.next=temp.next;
      temp.next.prev=temp.prev;
    }
    private void addNode(node temp){
          head.next.prev=temp;
          temp.next=head.next;
          head.next=temp;
          temp.prev=head;
    }
  
    public LRUCache(int capacity) {
        head=new node(-1,-1);
        tail=new node(-1,-1);
        head.next=tail;
        tail.prev=head;
        c=capacity;
        s=0;
        m=new HashMap<>();
    }
    
    public int get(int key) {
        if((!m.containsKey(key)) || m.isEmpty() ){
          return -1;
        }
        else{
          int v=m.get(key).val;
          node del=m.get(key);
          removeNode(del);
          addNode(del);
          return v;
          
      
        }
          
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
          node temp=m.get(key);
          temp.val=value;
          removeNode(temp);
          addNode(temp); 
        }
        else{
          if(s>=c){
             node del=tail.prev;
             removeNode(del);
             m.remove(del.key);
             s--;
          }
             node temp=new node(key,value);
           addNode(temp);
            m.put(key,temp);
            s++;
          }
      
            
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
