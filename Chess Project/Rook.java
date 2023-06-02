public class Rook extends Pieces{
    boolean hasMoved = false;
    
    //index[0] = row Index
    //index[1] = column Index
    public boolean canMove(int rowStart, int colStart, int rowEnd, int colEnd) { 

        String vDirection = "";
        String hDirection = "";

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


        if (!isInBounds(rowEnd, colEnd)) {
            return false;
        }

        //Check If Rook Can Move Horizontally
        if (hDirection.equals("right")) {
            for (int c = colStart+1; c <= colEnd; c++) {
                if (c < colEnd && board.getPiece(rowStart, c) != null) {
                    hasMoved = true;
                    return false;
                }

                if (c == colEnd) {
                    return canRelease(rowEnd, colEnd);
                }
            }
        }

        if (hDirection.equals("left")) { 
            for (int c = colStart-1; c >= colEnd; c--) {
                if (c > colEnd && board.getPiece(rowStart, c)!= null) {
                    return false;
                }

                if (c == colEnd) {
                    hasMoved = true;
                    return canRelease(rowEnd, colEnd);
                }
            }
        }

        //Check If Rook Can Move Vertically 
        if (vDirection.equals("down")) {
            for (int r = rowStart+1; r <= rowEnd; r++) {
                if (r < rowEnd && board.getPiece(r, colStart) != null) {
                    return false;
                }

                else if (r == rowEnd) {
                    hasMoved = true;
                    return canRelease(rowEnd, colEnd);
                }
            }
        }

        if (vDirection.equals("up")) {
            for (int r = rowStart-1; r >= rowEnd; r--) {
                if (r > rowEnd && board.getPiece(r, colStart) != null) {
                    return false;
                }

                else if (r == rowEnd) {
                    hasMoved = true;
                    return canRelease(rowEnd, colEnd);
                }
            }
        }

        return false;
    }

    public String toString(){
        return "Rook";
    }
}

