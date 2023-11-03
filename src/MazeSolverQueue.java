public class MazeSolverQueue extends MazeSolver{
    public static Maze myMaze; //instance vairable for the class

    private MyQueue worklist = new MyQueue();

    public MazeSolverQueue(){
        super(myMaze);
    }
    
    
    public void makeEmpty(){
        while (worklist.size() != 0){
            worklist.dequeue();
        }
    }



    //finish---------------------------------------------
    public boolean isEmpty(){ return true;}

    public void add(Square sq){

    }

    public Square next(){return new Square(0,0,1);}

}

