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
        if(!found && !sq.marked){ // Once again, check to make sure it isn't in the worklist currently, and hasn't been already previously explored
            workList.push(sq);
        }
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
