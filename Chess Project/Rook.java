public class Rook extends Pieces{
    
    public Rook() {

    }
    
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


        //Check If Rook Can Move Horizontally
        if (rowEnd == rowStart && (colEnd >= 0 && colEnd < 8)) {
            if (hDirection.equals("right")) {
                for (int c = colStart+1; c <= colEnd; c++) {
                    if (c < colEnd && board.getPiece(rowStart, c) != null) {
                        return false;
                    }

                    if (c == colEnd) {
                        super.isTaking(rowEnd, colEnd);
                    }
                }
            }

            if (hDirection.equals("left")) { 
                for (int c = colStart-1; c >= colEnd; c--) {
                    if (c > colEnd && board.getPiece(rowStart, c)!= null) {
                        return false;
                    }

                    if (c == colEnd) {
                        if (board.getPiece(rowEnd, colEnd) == null) {
                            return true;
                        }

                        if (board.getPiece(rowEnd, colEnd) !=  null) {
                            if (color.equals("white") && board.getPiece(rowEnd, colEnd).getColor().equals("black")) {
                                takesPiece = true;
                                return true;
                            }
                            
                            if (color.equals("black") && board.getPiece(rowEnd, colEnd).getColor().equals("white")) {
                                takesPiece = true;
                                return true;
                            }
                        }
                    }
                }
            }
        }

        //Check If Rook Can Move Vertically
        if (colEnd == colStart && (rowEnd >= 0 && rowEnd < 8)) {   
            if (vDirection.equals("down")) {
                for (int r = rowStart+1; r <= rowEnd; r++) {
                    if (r < rowEnd && board.getPiece(r, colStart) != null) {
                        return false;
                    }

                    else if (r == rowEnd) {
                        
                        super.isTaking(rowEnd, colEnd);
                    }
                }
            }

            if (vDirection.equals("up")) {
                for (int r = rowStart-1; r >= rowEnd; r--) {
                    if (r > rowEnd && board.getPiece(r, colStart) != null) {
                        return false;
                    }

                    else if (r == rowEnd) {
                        if (board.getPiece(rowEnd, colEnd) == null) {
                            return true;
                        }
                        if (board.getPiece(rowEnd, colEnd) !=  null) {
                            if (color.equals("white") && board.getPiece(rowEnd, colEnd).getColor().equals("black")) {
                                takesPiece = true;
                                return true;
                            }
                            
                            if (color.equals("black") && board.getPiece(rowEnd, colEnd).getColor().equals("white")) {
                                takesPiece = true;
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public String toString(){
        return "Rook";
    }
}

