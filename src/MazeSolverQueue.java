public class MazeSolverQueue extends MazeSolver{
    //public static Maze myMaze; //instance vairable for the class

    private MyQueue worklist = new MyQueue();
    private Maze myMaze;


    public MazeSolverQueue(Maze myMaze){
        super(myMaze);

        makeEmpty();
        this.myMaze = myMaze;
        worklist.enqueue(myMaze.getStart()); //worklist starts with the starting point
    }
    
    
    
    public void makeEmpty(){
        worklist = new MyQueue();
        add(myMaze.getStart());
         
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

        boolean found = false;
        for (int n = 0; n<worklist.size();n++){
            if(worklist.nextStep.get(n).equals(sq))
                found = true;
        }
        if(!found && !sq.marked){
            worklist.enqueue(sq);
        }
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

    


