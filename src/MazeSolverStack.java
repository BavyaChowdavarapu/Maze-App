public class MazeSolverStack extends MazeSolver {

    private Maze myMaze;
    private MyStack workList;

    public MazeSolverStack(Maze maze){
        super(maze);
        myMaze = maze;
    }
    
    public MyStack getWorkList(){
        return workList;
    }

    public void makeEmpty(){
        workList = new MyStack();
        workList.push(myMaze.getStart());
    }

    public boolean isEmpty(){
        if (workList != null){
            return workList.isEmpty();
        }
        makeEmpty();
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
