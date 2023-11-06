public class Square {

    private int row, col, type;
    private boolean valid = true;
    public Square previous;
    //public boolean marked;

    public Square(int row, int col, int type){
        this.row = row;
        this.col = col;
        this.type = type;
        this.previous  = null;
        //marked=false;


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
            return "_ ";
        }
        else if (type == 1){
            return "# ";
        }
        else if (type == 2){
            return "S ";
        }
        else if (type == 3){
            return "E ";
        }
        return "invalid parameter";
    }





}
