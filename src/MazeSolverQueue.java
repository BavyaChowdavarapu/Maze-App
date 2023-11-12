import java.util.*;

public class MazeSolverQueue extends MazeSolver{
    //public static Maze myMaze; //instance variable for the class

    private MyQueue worklist = new MyQueue();
    private Maze myMaze;


    public MazeSolverQueue(Maze myMaze){
        super(myMaze);
        this.myMaze = myMaze;
        //make the first thing in the worklist the starting point
        worklist.enqueue(myMaze.getStart());
    }
    
    
    
    public void makeEmpty(){
        this.worklist.clear();
    }


    public boolean isEmpty(){ 
        if (worklist.size() != 0){
            return false;
        }
        else {
            return true;
        }
    }

    public void add(Square sq){
        worklist.enqueue(sq);
    }

    public Square next(){
        Square mySquare = worklist.dequeue(); //gets the next step 
        
        //adds the neighbors of mySquare to the worklist 
        ArrayList<Square> mySqNeighbors = myMaze.getNeighbors(mySquare);

        for (Square sq : mySqNeighbors){//just changed this 
            //if the neighbor is the end point 
            if (sq.getType() == 3){
              //empty the worklist 
              step();
              makeEmpty();
              sq.setPrevious(mySquare);
              System.out.println(getPath());
              return sq;
            }
            
            //if the neighbor is not an end point but is an empty spot
            else if (sq.getType() == 0 ){
                add(sq);
            }
        }
        /*
        if (mySquare.previous != null){ 
            mySquare.previous.setType(0);
        }
        mySquare.setType(4);
        */
       
        return mySquare;
    }

    public MyQueue getWorkList(){
        return worklist;
    }
} 

    


