public abstract class MazeSolver {
    private Maze myMaze;

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    MazeSolver(Maze maze){};

    boolean isSolved(){
        if (isEmpty() || next().getType() == 3){
            return true;
        }
        else {
            return false;
        }
            
    }

    ///////////////finish 
    String getPath(){
        String coords = " "; 

        if (isSolved()){
            
            return coords;
        }
        else{
            return "No Solution Exists";
        }
    }

    ///////////////finsih 
    Square step(){
        Square mySquare = new Square(1,1, 1);;
        return mySquare;
    }

    void solve(){};
    
}
