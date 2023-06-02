public class King extends Pieces{
    public String toString(){
        return "King";
    }

    //index[0] = row Index
    //index[1] = column Index
    public boolean canMove(int rowStart, int colStart, int rowEnd, int colEnd) {
        return false;
    }

}
