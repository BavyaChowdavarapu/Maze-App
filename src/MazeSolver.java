import java.util.*;


public abstract class MazeSolver {
    private Maze myMaze;
    private MyQueue<Square> worklist;
    //private String path = "";

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    MazeSolver(Maze maze){
        myMaze = maze;
        worklist = new MyQueue<>();
        worklist.enqueue(myMaze.getStart());
    }

    boolean isSolved(){
        if (this.isEmpty() || myMaze.getFinish().getPrevious() != null /*|| next().getType() == 3*/){
            return true;
        }
        else {
            return false;
        }
            
    }

    String getPath(){
        String path = "";

        if (!this.isSolved() || (myMaze.getFinish().getPrevious() == null && this.isEmpty())){
            return "not solveable";
        }

        Stack<String> backtrack = new Stack<>();
        Square curr = maze.getFinish();

        while (!curr.equals(myMaze.getStart())){
            if (curr.getType() != 3){
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
        if (!worklist.isEmpty()){
            
            
            ArrayList neighbors = myMaze.getNeighbors(explore);
            for (Square n : neighbors){
                if (n.getType() == 3){
                    n.setPrevious(explore);
                    System.out.println(this.getPath());
                    return explore;
                }
                else if (n.getType() == 0){//if unexplored wall
                    n.setPrevious(explore); //previous is current now
                    n.setType(4);// current is now drone
                    worklist.add(n); //current is now in worklist
                }

                explore.setType(5);
                return explore;
            }
        
        }  
        return null;  //if worklist is empty
    }


    
    void solve(){
        //while worklist isn't empty and it isn't solved 
        while (!isEmpty() || !this.isSolved()){
            step();
        }
    }
    
}
