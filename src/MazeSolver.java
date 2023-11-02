import java.util.*;


public abstract class MazeSolver {
    private Maze myMaze;

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    MazeSolver(Maze maze){};

    boolean isSolved(){
        if (isEmpty() || next().getType() == 3){
            return true;
        }
        else {
            return false;
        }
            
    }

    ///////////////finish 
    String getPath(){
        String coords = " "; 

        if (isSolved()){
            
            return coords;
        }
        else{
            return "No Solution Exists";
        }
    }

    ///////////////finsih 
    Square step(){
        if (!isEmpty()){
            Square explore = next();
            if (explore.getType() == 3){
                System.out.println(getPath());
                return new Square(0,0,9);
            }
            else{
                ArrayList<Square> neighbors = myMaze.getNeighbors(explore);
                for (Square n : neighbors){
                    if (n.previous == null && n.getType() != 1){
                        add(n);
                        n.previous = explore;
                       
                    }
                }

                return explore;
            }
        
        }  
        return new Square(0,0,9);  
    }

    void solve(){};
    
}
