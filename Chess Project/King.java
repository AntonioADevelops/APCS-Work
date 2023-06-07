public class King extends Pieces{
    
    //index[0] = row Index
    //index[1] = column Index
    public boolean canMove(int rowStart, int colStart, int rowEnd, int colEnd) {
        if (!isInBounds(rowEnd, colEnd)) {
            return false;
        }

        //set movement to only 1 in any direction.
        if (Math.abs(rowEnd - rowStart) > 1 || Math.abs(colEnd - colStart) > 1) {
            return false;
        }

        if (color.equals("white") && board.getDangerB(rowEnd, colEnd) == true) {
            return false;
        }

        if (color.equals("black") && board.getDangerW(rowEnd, colEnd) == true) {
            return false;
        }

        return canRelease(rowEnd, colEnd);
    }
    
    public String toString(){
        return "King";
    }

}
