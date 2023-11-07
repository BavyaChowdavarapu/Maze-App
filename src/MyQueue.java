import java.util.NoSuchElementException;
import java.util.*;

public class MyQueue implements QueueADT{
    private LinkedList<Square> nextStep = new LinkedList<>();
    
    

    /**
     * Add an item to the queue
     * @param item the data item to add (of type T)
     */
    public void enqueue(Object item){
        nextStep.add((Square)item);
    }

    /**
     * Remove the front item from the queue
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Square dequeue() throws NoSuchElementException{
        Square newDrone = nextStep.removeFirst();
        //newDrone.drone = true;
        newDrone.setType(4);
        return newDrone;
    }

    /**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Square front() throws NoSuchElementException{
        return nextStep.getFirst();
    }

    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
    public int size(){
        return nextStep.size();
    }

    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty(){
        if (nextStep.size() == 0){
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
        nextStep.clear();
    }
}


