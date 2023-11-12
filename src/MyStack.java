import java.util.NoSuchElementException;
import java.util.*;

public class MyStack implements StackADT {
    private ArrayList<Square> nextStep;
    int size;

   
    public MyStack(){
        this.nextStep = new ArrayList<>();
        size = 0;
    }
    /**
    * Add an item onto the stack
    * @param item the data item to add (of type T)
    */
    public void push(Object item){
        Square itemm = (Square) item;
        size++;
        nextStep.add(itemm);
    }
    
    /**
    * Remove the top item from the stack
     * @return the top item in the stack
    * @throws NoSuchElementException if the stack is empty
     */
    public Square pop() throws NoSuchElementException{
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }

        Square returnThis = nextStep.remove(size() - 1);
        size--;
        return returnThis;
    }
    
    /**
     * Display the top item from the stack without removing it
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public Square top() throws NoSuchElementException{
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        Square thisStep = nextStep.get(nextStep.size() - 1);
        return thisStep;
    }

    /**
     * Find how many items are in the stack
     * @return the number of items in the stack
     */
    public int size(){
        
        int num = nextStep.size();
        return num;

    }

    /**
     * Determine if the stack is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty(){
        
        if (nextStep.size() == 0){
            return true;
        }
        else 
            return false;
    }

    /**
     * Clear out the data structure
     */
    public void clear(){
        nextStep = new ArrayList<>();
    }

    public String toString(){
        String steps = "[";

        for (Square x : this.nextStep) {
            steps += x + " ";
        }
        steps += " ";

        return steps;
    }
}
     
