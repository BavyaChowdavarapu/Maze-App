public class MazeSolverStack extends MazeSolver {

    //public static Maze maze;
    private MyStack workList;

    public MazeSolverStack(Maze maze){
        super(maze);
    }
    
    public MyStack getWorkList(){
        return workList;
    }

    public void makeEmpty(){
        workList = new MyStack();
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
