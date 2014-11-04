public class ReadyQueue {
  
    private Node first;
    private Node last;
    

    public Object peek() {
    
        if (isEmpty()) throw new NullPointerException();
        
        return first.data;
    }
  
    
    public void enq(Object item) {
      
        Node oldLast = last;
        last = new Node();
        last.data = item;
        last.next = null;
        
        if (isEmpty()) first = last;
        else oldLast.next = last;
    }
    
    
    public Object dnq() {
      
        if (isEmpty()) throw new NullPointerException();
        Object data = first.data;
        first = first.next;
        if (isEmpty()) last = null;
        
        return data;      
    }
    
    
    public boolean isEmpty() {
      
        return first == null;
    }
}