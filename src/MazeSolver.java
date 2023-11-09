import java.util.*;


public abstract class MazeSolver {
    private Maze myMaze;

    private String path = "";

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    MazeSolver(Maze maze){
        myMaze = maze;
    }

    boolean isSolved(){
        if (isEmpty() || next().getType() == 3){
            return true;
        }
        else {
            return false;
        }
            
    }

    String getPath(){
        return path;
    }

    /* 
    Square step(){
        if (!isEmpty()){
            Square explore = next();
            if (explore.getType() == 3){
                System.out.println(getPath());
                return explore;
            }
            else{
                ArrayList<Square> neighbors = myMaze.getNeighbors(explore);
                for (Square n : neighbors){
                    if (n.marked == false && n.getType() != 1){
                        add(n);
                        n.previous = explore;
                        n.marked = true;
                        
                       
                    }
                }
                if (explore.previous != null)
                    explore.previous.setType(0);
                explore.setType(4);
                return explore;
            }
        
        }  
        return new Square(0,0,9);  
    }
*/



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

    
    void solve(){
        Square temp = new Square (0,0,2);
        while (!isEmpty() || temp.getType() == 3){
            temp = step();
            path = path+"["+temp.getRow()+","+temp.getCol()+"]";
        }
    }
    
}
