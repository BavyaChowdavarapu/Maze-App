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
        return null;  
    }


    
    void solve(){
        Square temp = new Square (0,0,2);
        while (!isEmpty() || temp.getType() == 3){
            temp = step();
            path = path+"["+temp.getRow()+","+temp.getCol()+"]";
        }
    }
    
}
