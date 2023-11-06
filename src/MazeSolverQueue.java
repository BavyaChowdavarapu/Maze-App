public class MazeSolverQueue extends MazeSolver{
    //public static Maze myMaze; //instance vairable for the class

    private MyQueue worklist = new MyQueue();

    public MazeSolverQueue(Maze myMaze){
        super(myMaze);
    }
    
    
    public void makeEmpty(){
        while (worklist.size() != 0){
            worklist.dequeue();
        }
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
        worklist.dequeue();
        return worklist.front();
    }

    public MyQueue getWorkList(){
        return worklist;
    }

    

}

