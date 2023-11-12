import java.util.*;


public abstract class MazeSolver {
    private Maze myMaze;

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    abstract Square nextPeek();

    public boolean nextEnd = false;
    public boolean done = false;
    

    MazeSolver(Maze maze){
        myMaze = maze;
    }

    boolean isSolved(){
        return done;
            
    }

    public String getPath(){
        String path = "";

        if (!this.isSolved() || (myMaze.getFinish().getPrevious() == null && this.isEmpty())){
            return "not solved";
        }

        Stack<String> backtrack = new Stack<>();
        Square curr = myMaze.getFinish(); //check why end is being set to null

        while (!curr.equals(myMaze.getStart())){
            if (curr.startingType != 3){
                curr.setType(6); //sets completed path to x's at the end
            }
            backtrack.push(", [" + curr.getRow() + ", " + curr.getCol() + "]");
            curr = curr.getPrevious();
        }

        path = path + "[" + curr.getRow() + ", " + curr.getCol() + "]";
        while (!backtrack.isEmpty()){
            path = path + backtrack.pop();
        }

        return path;
       
    }

    
    Square step(){
        /* 
        if (!isEmpty() && nextPeek() == myMaze.getFinish()){ 
                nextEnd = true;
                Square ending = myMaze.getFinish();
               
                while (ending.previous != null){ //X's for the final path are only showing if you switch from "Queue" to "Stack"
                                                 // or vice versa, as it's not updating the board until you switch methods.
                    ending = ending.previous;
                    ending.setType(6);
                    
                }
            }
        */
        if (isEmpty()){
            done = true;
            return null;
            }

        else{

            Square explore = next();

            if (explore.getType() == 3){
                nextEnd = true;
                done = true;
                return explore;
            }
                else{
                    
                    ArrayList<Square> neighbors = myMaze.getNeighbors(explore);
                    for (Square n : neighbors){
                        if (n.getType() == 0 || n.getType() == 3){
                            add(n);
                            if (!n.inWorkList){
                                n.previous = explore;
                                
                            }
                            n.inWorkList = true;
                            
                        
                        }
                    }
                    explore.marked = true;
                    
                    
                }


            return explore;
        } 
            
        }
        
            
      
        
    
    void solve(){
        while(!done){
            step();
        }
        
    }
 
    
}
