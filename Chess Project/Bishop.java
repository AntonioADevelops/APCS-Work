
public class Bishop extends Pieces{
    public String toString(){
        return "Bishop";
    }

    //index[0] = row Index
    //index[1] = column Index
    public boolean canMove(int rowStart, int colStart, int rowEnd, int colEnd) {

        String vDirection = "";
        String hDirection = "";

        int vChange = Math.abs(rowEnd - rowStart);
        int hChange = Math.abs(colEnd - colStart);
        
        if (rowEnd > rowStart) {
            vDirection = "down";
        }
        else {
            vDirection = "up";
        }

        if (colEnd > colStart) {
            hDirection = "right";
        }
        else {
            hDirection = "left";
        }

        if (vChange != hChange) {
            return false;
        }

        if (!isInBounds(rowEnd, colEnd)) {
            return false;
        }

        if (hDirection.equals("right")) {
            //Check if bishop can move up to the right
            if (vDirection.equals("up")) {
                while (rowStart-1 > rowEnd && colStart+1 < colEnd) {
                    if (board.getPiece(rowStart-1, colStart+1) != null) {
                        return false;
                    }
                    rowStart--;
                    colStart++;
                }

                return canRelease(rowEnd, colEnd);
            }   

            //Check if biship can move down to the right
            if (vDirection.equals("down")) {
                while (rowStart+1 < rowEnd && colStart+1 < colEnd) {
                    if (board.getPiece(rowStart+1, colStart+1) != null) {
                        return false;
                    }
                    rowStart++;
                    colStart++;
                }

                return canRelease(rowEnd, colEnd);
            }
        }

        if (hDirection.equals("left")) {
            //Check If Piece Can Move Up to the Left
            if (vDirection.equals("up")) {
                while (rowStart-1 > rowEnd && colStart-1 > colEnd) {
                    if (board.getPiece(rowStart-1, colStart-1) != null) {
                        return false;
                    }
                    rowStart--;
                    colStart--;
                }

                return canRelease(rowEnd, colEnd);
            }   

            //Check If Piece Can Move Down to the Left
            if (vDirection.equals("down")) {
                while (rowStart+1 < rowEnd && colStart-1 > colEnd) {
                    if (board.getPiece(rowStart+1, colStart-1) != null) {
                        return false;
                    }
                    rowStart++;
                    colStart--;
                }

                return canRelease(rowEnd, colEnd);
            }
        }

        return false;
    }
}
