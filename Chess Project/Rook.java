public class Rook extends Pieces{
    boolean hasMoved = false;

    //index[0] = row Index
    //index[1] = column Index
    public boolean canMove(int rowStart, int colStart, int rowEnd, int colEnd) { 
        handleDirection(rowStart, colStart, rowEnd, colEnd);

        if (!isInBounds(rowEnd, colEnd)) {
            return false;
        }

        return checkStraightMovement(rowStart, colStart, rowEnd, colEnd);
    }

    public String toString(){
        return "Rook";
    }
}

