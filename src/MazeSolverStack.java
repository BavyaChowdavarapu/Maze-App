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
        return workList.isEmpty();

    }

    public void add(Square sq){
        workList.push(sq);
    }
    
    public Square next(){
        return workList.pop();
    }
}
