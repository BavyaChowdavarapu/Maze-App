public class Square {

    private int row, col, type;
    private boolean valid = true;

    public Square(int row, int col, int type){
        this.row = row;
        this.col = col;
        this.type = type;

        if (type != 0 && type != 1 && type != 2 && type!=3){
            valid = false;
        }

    }
    
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public int getType(){
        if (valid)
            return type;
        else
            return -1;
    }

    public String toString(){
        if (type == 0){
            return "_ - empty space (0)";
        }
        else if (type == 1){
            return "# - wall (1)";
        }
        else if (type == 2){
            return "S - start (2)";
        }
        else if (type == 3){
            return "E - exit (3)";
        }
        return "invalid parameter";
    }





}
