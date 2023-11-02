import java.util.NoSuchElementException;
import java.util.*;

public class MyQueue {
    private LinkedList<Square> nextStep = new LinkedList<>();
    
 
    /**
     * Add an item to the queue
     * @param item the data item to add (of type T)
     */
    void enqueue(Square item){
        nextStep.add(item);
    }

    /**
     * Remove the front item from the queue
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    Square dequeue() throws NoSuchElementException{

        return nextStep.removeFirst();
    }

    /**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    Square front() throws NoSuchElementException{
        return nextStep.getFirst();
    }

    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
    int size(){
        return nextStep.size();
    }

    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    boolean isEmpty(){
        return nextStep.isEmpty();
    }

    /**
     * Clear out the data structure
     */
    void clear(){
        nextStep.clear();
    }


    

}


