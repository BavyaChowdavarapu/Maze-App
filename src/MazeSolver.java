
import java.util.*;


public abstract class MazeSolver {
    private Maze myMaze;
    MyQueue worklist;
    //private String path = "";

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    MazeSolver(Maze maze){
        myMaze = maze;
        worklist = new MyQueue();
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
        
        if (!worklist.isEmpty()){//worklist isn't empty
            Square explore;
            
            explore = this.next();
            
            ArrayList<Square> neighbors = myMaze.getNeighbors(explore);
            for (Square n : neighbors){
                if (n.getType() == 3){//this isn't working 
                    n.setPrevious(explore); 
                    this.makeEmpty();//just chnaged this -----------------------
                    System.out.println(this.getPath());
                    return explore;
                    //n.setPrevious(explore);
                }
                else if (n.getType() == 0){//if unexplored wall
                    n.setPrevious(explore); //previous is current now
                    n.setType(4);// current is now drone
                    this.add(n); //current is now in worklist
                }

                explore.setType(5);
                return explore;
            }
        
            
            
        }  
        
        return null;  //if worklist is empty 
    }


    
    void solve(){
        //while worklist isn't empty and it isn't solved 
        while (/*!isEmpty() ||*/ !this.isSolved()){
            step();
        }
        
        if (this.isSolved()){//just changed this 
            System.out.println(this.getPath());
        }
    }
    
}
