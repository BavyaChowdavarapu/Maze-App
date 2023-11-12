public class MazeSolverStack extends MazeSolver {

    private Maze myMaze;
    private MyStack<Square> workList = new MyStack<>();

    public MazeSolverStack(Maze maze){
        super(maze);
        myMaze = maze;
        worklist.push(myMaze.getStart());
    }
    
    public MyStack getWorkList(){
        return workList;
    }

    public void makeEmpty(){
        workList = new MyStack<>();
    }

    public boolean isEmpty(){
        if (workList != null){
            return false;
        }
        //if worklist is null
        return true;
    }

    public void add(Square sq){
        workList.push(sq);
    }
    
    public Square next(){
        Square mySquare = workList.pop();

        /*
        if (mySquare.previous != null){ 
            mySquare.previous.setType(0);
        }
        mySquare.setType(4);
        */
        return mySquare;
    }
}
