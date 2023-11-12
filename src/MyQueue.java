import java.util.NoSuchElementException;
import java.util.*;

public class MyQueue implements QueueADT{
    private LinkedList<Square> nextStep = new LinkedList<>();
    private Node start;
    private Node end;
    

    public MyQueue(){
        start = null;
        end = null;
    }

    /**
     * Add an item to the queue
     * @param item the data item to add (of type T)
     */
    public void enqueue(Object item){
       Node myNode = new Node ((Square) item);

       if (start == null){
        start = myNode;
        end = myNode;
        return;
       }

       //if the start is not null
       end.next = myNode;
       end = myNode;
    }

    /**
     * Remove the front item from the queue
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Square dequeue() throws NoSuchElementException{
        if (start == null){
            throw new NoSuchElementException();
        }
        Square newDrone = start.data;
        start = start.next();
        return newDrone;
        
        //Square newDrone = nextStep.removeFirst();
        //newDrone.drone = true;
        //newDrone.setType(4);
        //return newDrone;
    }

    /**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Square front() throws NoSuchElementException{
        if (start == null){
            throw new NoSuchElementException();
        }
        return start.data;
    }

    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
    public int size(){
        int s = 0;
        Node thisNode = start;
        while (thisNode != null){
            s++;
            thisNode = thisNode.next;
        }

        return s;
    }

    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty(){
        if (start == null){
            return true;
        }
        else {
            return false;
        }
        
        
    }

    /**
     * Clear out the data structure
     */
    public void clear(){
        start = null;
        end = null;
    }

    private class Node{
        public Square data;
        public Node next;

        public Node(Square n){
            this.data = n;
            this.next = null;
        }
    }
}


