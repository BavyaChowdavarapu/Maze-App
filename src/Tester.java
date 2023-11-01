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


    //MYSTACK UNIT TESTS
    MyStack myStack = new MyStack();
    //myStack.pop(); //should throw exception (works)
    myStack.push(t1);

    System.out.println(myStack.top().getRow()); 
    System.out.println(myStack.pop().getRow());

    myStack.push(t1);
    myStack.push(t2);
    myStack.push(t3);
    myStack.push(t4);
    myStack.push(t5);

    System.out.println(myStack.size());
    
    System.out.println(myStack.isEmpty());

    myStack.clear();

    System.out.println(myStack.isEmpty());

    //MyQueue Unit Tests
    System.out.println("MY QUEUE TESTS:");

    MyQueue thing = new MyQueue();
    thing.enqueue(t1);
    thing.enqueue(t2);
    thing.enqueue(t3);
    thing.enqueue(t4);
    System.out.println(thing.dequeue().getType());
    System.out.println(thing.size());
    System.out.println(thing.front().getType());
    thing.clear();
    System.out.println(thing.isEmpty());
}


}