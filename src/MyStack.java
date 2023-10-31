import java.util.NoSuchElementException;
import java.util.*;

public class MyStack {
    ArrayList<Square> nextStep = new ArrayList<>();

   
    /**
    * Add an item onto the stack
    * @param item the data item to add (of type T)
    */
    void push(Square item){
        nextStep.add(item);
    }
    
    /**
    * Remove the top item from the stack
     * @return the top item in the stack
    * @throws NoSuchElementException if the stack is empty
     */
    Square pop() throws NoSuchElementException{
        Square thisStep = nextStep.remove(nextStep.size() -1);
        return thisStep;
    }
    
    /**
     * Display the top item from the stack without removing it
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    Square top() throws NoSuchElementException{
        Square thisStep = nextStep.get(nextStep.size() - 1);
        return thisStep;
    }

    /**
     * Find how many items are in the stack
     * @return the number of items in the stack
     */
    int size(){
        int num = nextStep.size();
        return num;

    }

    /**
     * Determine if the stack is empty
     * @return true if the size is 0, false otherwise
     */
    boolean isEmpty(){
        if (nextStep.size() == 0){
            return true;
        }
        else 
        return false;
    }

    /**
     * Clear out the data structure
     */
    void clear(){
        while (nextStep.size() != 0){
            nextStep.remove(nextStep.size() - 1);
        }
    }

}
     











