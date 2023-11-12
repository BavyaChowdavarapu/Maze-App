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
        if (!isEmpty() && nextEnd){
            Square end = myMaze.getFinish();
            String endPath = "[" +end.getRow() + "," + end.getCol() + "]";
            while (end.previous != null){
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
