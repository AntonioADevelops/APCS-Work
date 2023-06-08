public class Queen extends Pieces{
    
    //index[0] = row Index
    //index[1] = column Index
    public boolean canMove(int rowStart, int colStart, int rowEnd, int colEnd) {
        
        handleDirection(rowStart, colStart, rowEnd, colEnd);
        
        calcDistanceChange(rowStart, colStart, rowEnd, colEnd);

        if (!isInBounds(rowEnd, colEnd)) {
            return false;
        }

        //Check is queen is moving diagonally
        if (vChange == hChange) {
            return checkDiagonalMovement(rowStart, colStart, rowEnd, colEnd);
        }

       return checkStraightMovement(rowStart, colStart, rowEnd, colEnd);
    }

    public String toString(){
        return "Queen";
    }

}
