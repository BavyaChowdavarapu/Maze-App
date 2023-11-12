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

        if (!this.isSolved() || (myMaze.getFinish().previous == null && this.isEmpty())){
            return "not solved";
        }

        Stack<String> backtrack = new Stack<>();
        Square curr = myMaze.getFinish(); //check why end is being set to null

        while (!curr.equals(myMaze.getStart())){
            if (curr.startingType != 3){
                curr.inFinalPath = true;
            }
            backtrack.push(", [" + curr.getRow() + ", " + curr.getCol() + "]");
            curr = curr.previous;
        }

        path = path + "[" + curr.getRow() + ", " + curr.getCol() + "]";
        while (!backtrack.isEmpty()){
            path = path + backtrack.pop();
        }

        return path;
       
    }

    
    Square step(){
        
        
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
