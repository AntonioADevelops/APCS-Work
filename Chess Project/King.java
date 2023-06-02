public class King extends Pieces{
    public String toString(){
        return "King";
    }

    //index[0] = row Index
    //index[1] = column Index
    public boolean canMove(int rowStart, int colStart, int rowEnd, int colEnd) {
        if (!isInBounds(rowEnd, colEnd)) {
            return false;
        }

        if (rowEnd > rowStart+1 || colEnd > colStart+1 || rowEnd < rowStart-1 || colEnd < colStart-1) {
            return false;
        }

        return canRelease(rowEnd, colEnd);
    }

}
