public class MazeSolverStack extends MazeSolver {

    private Maze myMaze;
    private MyStack workList = new MyStack();
    

    public MazeSolverStack(Maze maze){
        super(maze);

        makeEmpty();
        myMaze = maze;
        workList.push(myMaze.getStart());
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
        

        boolean found = false;
        for (int n = 0; n<workList.size();n++){
            if(workList.nextStep.get(n).equals(sq))
                found = true;
        }
        if(!found && !sq.marked){
            workList.push(sq);
        }
    }
    
    public Square nextPeek(){
        return workList.top();
    }


    public Square next(){
        Square mySquare = workList.pop();

        
        return mySquare;
    }
}
