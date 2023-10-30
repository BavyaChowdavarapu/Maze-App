class Tester{


public static void main(String[] args) {
    //SQUARE CLASS UNIT TESTS
    Square t1 = new Square(1,1,9);
    Square t2 = new Square(1,1,0);
    Square t3 = new Square(1,1,1);
    Square t4= new Square(1,1,2);
    Square t5 = new Square(1,1,3);

    /* 
    System.out.println(t1.getType());
    System.out.println(t2.getType());
    System.out.println(t3.getType());
    System.out.println(t4.getType());
    System.out.println(t5.getType());
    */

    //MAZE SKELETON UNIT TESTS
    Maze newMaze = new Maze ();
    newMaze.loadMaze("src/maze-2");

    System.out.println("Start = " +newMaze.getStart());
    System.out.println("End = " +newMaze.getFinish());

    System.out.println("Neighbors: "+newMaze.getNeighbors(newMaze.getStart()));
    System.out.println(newMaze);

    



}


}