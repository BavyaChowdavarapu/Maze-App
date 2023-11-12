import java.util.*;

public class MazeSolverStack extends MazeSolver {

    private Maze myMaze;
    private MyStack workList = new MyStack();

    public void add(Square sq){
        workList.push(sq);
    }
    
    public MazeSolverStack(Maze maze){
        super(maze);
        myMaze = maze;
        add(myMaze.getStart());
    }
    
    public MyStack getWorkList(){
        return workList;
    }

    public void makeEmpty(){
        workList = new MyStack();
    }

    public boolean isEmpty(){
        //if (workList != null){
            //return false;
        //}
        //if worklist is null
        return worklist.isEmpty();
        //return true;
    }

    public Square next(){
        Square mySquare = workList.pop();

        //adds the neighbors of mySquare to the worklist 
        ArrayList<Square> mySqNeighbors = myMaze.getNeighbors(mySquare);

        for (Square sq : mySqNeighbors){//just changed this 
            //if one of the neighbor options is the end point 
            if (sq.getType() == 3){
              //empty the worklist 
              sq.setPrevious(mySquare);
              System.out.println(getPath());
              step();
              makeEmpty();
              return sq;
            }
            
            //if the neighbor is not the end point but is an empty spot
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
}
