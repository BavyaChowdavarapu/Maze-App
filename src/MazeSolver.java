import java.util.*;


public abstract class MazeSolver {
    private Maze myMaze;

    private String path = "";

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    public boolean nextEnd = false;
    public boolean done = false;
    

    MazeSolver(Maze maze){
        myMaze = maze;
    }

    boolean isSolved(){
        return done;
            
    }

    public String getPath(){
        // If the worklist isn't empty and the next square is the end
        if (!isEmpty() && nextEnd){
            Square end = myMaze.getFinish();
            String endPath = "[" +end.getRow() + "," + end.getCol() + "]";
            while (end.previous != null){ //Iterates backwards from the end to the start by using the public previous variable
                end = end.previous;
                end.inFinalPath = true;
                endPath = endPath + "[" +end.getRow() + "," + end.getCol() + "]";
            }
            return endPath;
        }
        else{
            return "Can't get the path just yet";
        }
       
    }

    
    Square step(){
        if (isEmpty()){ //If the worklist is empty, the maze is done/solved
            done = true;
            return null;
            }

        else{
            Square explore = next();

            if (explore.getType() == 3){ //If the next square is the end, then the maze is done, and the next square is the ending square
                nextEnd = true;
                done = true;
                return explore;
            }
                else{
                    
                    ArrayList<Square> neighbors = myMaze.getNeighbors(explore);
                    for (Square n : neighbors){
                        if (n.getType() == 0 || n.getType() == 3){
                            add(n);
                            if (!n.inWorkList){ //if the square isn't in the worklist, then set the previous to explore from the worklist
                                n.previous = explore;
                                
                            }
                            n.inWorkList = true; //then add that its in the worklist
                            
                        
                        }
                    }
                    explore.marked = true; //then add that its been explored/marked
                    
                    
                }

            return explore;
        }
           
            
    }  
        
    
    
    void solve(){
        while(!done){ //While the maze hasn't been solved, keep stepping through it
            step();
        }
    }
 
    
}
