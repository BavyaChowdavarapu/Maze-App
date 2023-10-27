import java.util.*;
import java.io.*;

public class Maze {
    private Square[][] maze;

    public Maze(){

    }

    public boolean loadMaze(String fName){
        File newFile = new File(fName);
        try{
        Scanner file = new Scanner(newFile);

        int numCols = Integer.parseInt(file.next());
        int numRows = Integer.parseInt(file.next()); //test out if the space between the numbers jumbles it up
        
        
        this.maze = new Square[numRows][numCols];

        
        for (int row=0; row < numRows; row++) {
            for (int col=0; col < numCols; col++) {
                maze[row][col] = null;            }
        }

        System.out.println(numRows);
        System.out.println(numCols);


        
        }
        catch(Exception e){
            System.out.println("File not found");
        }
       
        return true;



    }

    /*public ArrayList<Square> getNeighbors(Square sq){

    }

    public Square getStart(){

    }

    public Square getFinish(){

    }

    public void reset(){

    }

    public String toString(){

    }
    */
}
