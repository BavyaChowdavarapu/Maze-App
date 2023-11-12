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
        
    



    /* 
     Square step(){
        if (isEmpty()){
            // If the worklist is empty, there's nothing to explore, and the maze is unsolvable.
            return null;  
        }
        
        Square current = next(); // Get the next square to explore
        
        if (current.getType() == 3){ // Check if it's the end
            // Trace back the path from end to start, marking it along the way
            markPath(current);
            return current;
        }
    
        current.marked = true; // Mark the current square as visited
    
        ArrayList<Square> neighbors = myMaze.getNeighbors(current); // Get neighbors
        for (Square neighbor : neighbors){
            // If the neighbor has not been visited and is not a wall, add it to the worklist
            if (!neighbor.marked && neighbor.getType() != 1){
                add(neighbor);
                neighbor.previous = current; // Set the previous to track the path
            }
        }
        
        return current;
    }
    
    private void markPath(Square end){
        Square current = end;
        while (current.previous != null) {
            //current.setType(Square.PATH); // Set the square as part of the path
            current.marked = true;
            current = current.previous; // Move to the previous square
        }
        //current.setType(Square.START); // Mark the starting square
    }
    */
    
    void solve(){
        while(!done){
            step();
        }
    }
 /* 
    public void solve(){
        makeEmpty(); // Initialize the worklist/stack/queue
        add(myMaze.getStart()); // Add the starting point to the worklist/stack/queue
    
        Square current;
        while (!isEmpty()) {
            current = step();
            System.out.println(myMaze);
            System.out.println("---------------");
            if (current == null) {
                // If step() returns null, there are no more squares to explore, and the maze is unsolvable.
                break;
            }
            if (current.getType() == 3) {
                // If we've reached the end, construct the path string from the end to the start.
                constructPath(current);
                break;
            }
        }
    }
    
    private void constructPath(Square end){
        path = ""; // Reset the path
        Square current = end;
        while (current.previous != null) {
            path = "[" + current.getRow() + "," + current.getCol() + "] " + path;
            current = current.previous; // Move to the previous square
        }
        path = "[" + current.getRow() + "," + current.getCol() + "] " + path; // Add the start square
    }
    */
    
}
