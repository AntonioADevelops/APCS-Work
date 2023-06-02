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

        //Check If Queen Can Move Horizontally
        if (rowEnd == rowStart && (colEnd >= 0 && colEnd < 8)) {
            if (hDirection.equals("right")) {
                for (int c = colStart+1; c <= colEnd; c++) {
                    if (c < colEnd && board.getPiece(rowStart, c) != null) {
                        return false;
                    }

                    else if (c == colEnd) {
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

            if (hDirection.equals("left")) { 
                for (int c = colStart-1; c >= colEnd; c--) {
                    if (c > colEnd && board.getPiece(rowStart, c)!= null) {
                        return false;
                    }

                    else if (c == colEnd) {
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

        //Check If Queen Can Move Vertically
        if (colEnd == colStart && (rowEnd >= 0 && rowEnd < 8)) {   
            if (vDirection.equals("down")) {
                for (int r = rowStart+1; r <= rowEnd; r++) {
                    if (r < rowEnd && board.getPiece(r, colStart) != null) {
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

        //Check If Queen Is Moving Diagonally
        if (vChange != hChange) {
            return false;
        }

        //Check if Queen Can Move Diagonally Right
        if (hDirection.equals("right")) {

            //Check If Piece Can Move Up to the Right
            if (vDirection.equals("up")) {
                while (rowStart-1 > rowEnd && colStart+1 < colEnd) {
                    if (board.getPiece(rowStart-1, colStart+1) != null) {
                        return false;
                    }
                    rowStart--;
                    colStart++;
                }

                if (board.getPiece(rowEnd, colEnd) == null) {
                    return true;
                }

                if (board.getPiece(rowEnd, colEnd) != null) { 
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

            //Check If Piece Can Move Down to the Right
            if (vDirection.equals("down")) {
                while (rowStart+1 < rowEnd && colStart+1 < colEnd) {
                    if (board.getPiece(rowStart+1, colStart+1) != null) {
                        return false;
                    }
                    rowStart++;
                    colStart++;
                }

                if (board.getPiece(rowEnd, colEnd) == null) {
                    return true;
                }

                if (board.getPiece(rowEnd, colEnd) != null) { 
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

        //Check if Queen Can Move Diagonally Left
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

                if (board.getPiece(rowEnd, colEnd) == null) {
                    return true;
                }

                if (board.getPiece(rowEnd, colEnd) != null) { 
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

            //Check If Piece Can Move Down to the Left
            if (vDirection.equals("down")) {
                while (rowStart+1 < rowEnd && colStart-1 > colEnd) {
                    if (board.getPiece(rowStart+1, colStart-1) != null) {
                        return false;
                    }
                    rowStart++;
                    colStart--;
                }

                if (board.getPiece(rowEnd, colEnd) == null) {
                    return true;
                }

                if (board.getPiece(rowEnd, colEnd) != null) { 
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

        return false;
    }

}
