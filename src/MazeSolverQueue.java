public class MazeSolverQueue extends MazeSolver{
    //public static Maze myMaze; //instance vairable for the class

    private MyQueue<Square> worklist = new MyQueue<>();
    private Maze myMaze;


    public MazeSolverQueue(Maze myMaze){
        super(myMaze);
        this.myMaze = myMaze;
        //make the first thing in the worklist the starting point
        worklist.enqueue(myMaze.getStart());
    }
    
    
    
    public void makeEmpty(){
        this.worklist.clear();
    }


    public boolean isEmpty(){ 
        if (worklist.size() != 0){
            return false;
        }
        else {
            return true;
        }
    }

    public void add(Square sq){
        worklist.enqueue(sq);
    }

    public Square next(){
        Square mySquare = worklist.dequeue(); //gets the next step 
        

        /*
        if (mySquare.previous != null){ 
            mySquare.previous.setType(0);
        }
        mySquare.setType(4);
        */
        return mySquare;
    }

    public MyQueue getWorkList(){
        return worklist;
    }
} 

    


