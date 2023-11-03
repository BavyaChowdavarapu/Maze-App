import java.util.*;
import java.io.*;

public class Maze {
    private Square[][] maze;
    private Square start;
    private Square end;
    private int numRows, numCols;

    public Maze(){

    }

    public boolean loadMaze(String fName){
        File newFile = new File(fName);
        try{
        Scanner file = new Scanner(newFile);

        numRows = file.nextInt();
        numCols = file.nextInt(); //test out if the space between the numbers jumbles it up
        
        
        this.maze = new Square[numRows][numCols];

        
        for (int row=0; row < numRows; row++) {
            for (int col=0; col < numCols; col++) {
                maze[row][col] = new Square(row,col,file.nextInt());            }
        }


    

        
        }
        catch(Exception e){
            System.out.println("File not found");
        }
       
       




        //Finds and saves the start/end of the maze
        for(Square[] square : this.maze){
             for(Square sq : square){
                if (sq.getType() == 2)
                    start = sq;
                else if (sq.getType() == 3)
                    end = sq;

            }
        }
         return true;

    }

    public ArrayList<Square> getNeighbors(Square sq){
        ArrayList<Square> neighbors = new ArrayList<>();
        try {
            int row = sq.getRow();
            int col = sq.getCol();
            neighbors.add(maze[row-1][col]);//North
        }
        catch(Exception e){
            
        }
        try {
            int row = sq.getRow();
            int col = sq.getCol();
            neighbors.add(maze[row][col+1]);//East
        }
        catch(Exception e){
            
        }
        try {
            int row = sq.getRow();
            int col = sq.getCol();
            neighbors.add(maze[row+1][col]);//South
        }
        catch(Exception e){
            
        }
        try {
            int row = sq.getRow();
            int col = sq.getCol();
            neighbors.add(maze[row][col-1]); //West
        }
        catch(Exception e){
            
        }
        return neighbors;
    }

    public Square getStart(){
        return start;
    }

    public Square getFinish(){
        return end;
    }

    //TO DO LATER
    public void reset(){
        
    }

    public String toString(){

        String finalMaze = "";
        for (int r =0; r<numRows; r++){
            for (int c = 0; c<numCols; c++){
                finalMaze = finalMaze + maze[r][c] + " ";
            }
            finalMaze = finalMaze + "\n";

        }
        return finalMaze;
    }
    
}
