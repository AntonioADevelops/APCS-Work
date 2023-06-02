public class Queen extends Pieces{
    public String toString(){
        return "Queen";
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

        if (!isInBounds(rowEnd, colEnd)) {
            return false;
        }

        //Check if queen is moving diagonally
        if (vChange == hChange) {
            
            //Check if queen is moving diagonally right
            if (hDirection.equals("right")) {

                //Check if queen can move up and to the right
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

                //Check if queen can move down and to the right.
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

            //Check if queen is moving diagonally left
            if (hDirection.equals("left")) {
                
                //Check if queen can move up and to the left
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

                //Check if queen can move down and to the left
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
        }

        //Check if queen is moving horizontally.
        if (hDirection.equals("right")) {
            for (int c = colStart+1; c <= colEnd; c++) {
                if (c < colEnd && board.getPiece(rowStart, c) != null) {
                    return false;
                }

                else if (c == colEnd) {
                    return canRelease(rowEnd, colEnd);
                }
            }
        }

        if (hDirection.equals("left")) { 
            for (int c = colStart-1; c >= colEnd; c--) {
                if (c > colEnd && board.getPiece(rowStart, c)!= null) {
                    return false;
                }

                else if (c == colEnd) {
                    return canRelease(rowEnd, colEnd);
                }
            }
        }

        //Check if queen is moving vertically.
        if (vDirection.equals("down")) {
            for (int r = rowStart+1; r <= rowEnd; r++) {
                if (r < rowEnd && board.getPiece(r, colStart) != null) {
                    return false;
                }

                else if (r == rowEnd) {
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
                    return canRelease(rowEnd, colEnd);
                }
            }
        }
        
        return false;
    }

}
