package main;

public class MovingAverageLinkedList implements MovingAverage {

	//Node class to implement Linked List
    private static class Node{

        private Long value;
        private Node next;
        
        public Node(Long value){
            this.value = value;
            next = null;
        }

    } 

    private int windowSize;
    private int size;
    private long sum;
    
    private Node head;
    private Node tail;
    private Node windowStart;

    public MovingAverageLinkedList(int windowSize) throws Exception {
        // Window size should always be positive
        if(windowSize < 1 ){
            throw new Exception("N should always be a positive integer");
        }
        this.windowSize = windowSize;
        head = null;
        windowStart = null;
        tail = null;
        size = 0;
        sum = 0;
    }

    /*This method adds element at the end of the list while keeping track of the Node from where the window starts.
      On addition of new element the the window start node is moved forward by one */
    @Override
	public void add(long value) {
        Node newNode = new Node(value);
        // Insert the node to the list
        if(size == 0){
            head = newNode;
            tail = head;
        }else{
            tail.next = newNode;
            tail = tail.next; 
        }

        //Slide Average Window
        if(size < windowSize){
            windowStart = head;
        }else{
            sum -= windowStart.value;
            windowStart = windowStart.next;
        }

        sum += value;
        size++;

    }
    
    /*Returns Moving average while ensuring if the number of elements in the list are less than the window size. It should only return the Average for those elements.
      For example: If the windows size is set to 10 but this method is called when the list contains only 5 elements. It will only return the average of the 5 elements in the list */
    @Override
    public double getAverage() {
        if(size == 0) return 0;

        if(size < windowSize){
            return (double)sum / (double) size;
        }
            
        return (double)sum / (double)windowSize;
    }

    // Returns the element at requested index by iterating to that position.
    @Override
    public long get(int index) {
        if(index >=size || index < 0){
            throw new IndexOutOfBoundsException("Please check the index");
        }

        if(index == size-1) return tail.value;

        Node result = head;
        for(int i=0;i<index;i++){
            result = result.next;
        }
        return result.value;
    }

    @Override
    public int getSize() {
        return size;
    }
    
}
