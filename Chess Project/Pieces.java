public abstract class Pieces{
    
    protected static Board board;
    protected boolean takesPiece = false;
    protected String color = "";

    protected String vDirection = "";
    protected String hDirection = "";

    protected int vChange;
    protected int hChange;

    

    //Sets color of piece
    public void setColor(String c) {
        color = c;
    }

    //Gets color of piece
    public String getColor() {
        return color;
    }

    //Sets the board the piece is on
    public static void setBoard(Board b) {
        board = b;
    }

    //Gets the board the piece is on
    public Board getBoard() {
        return board;
    }

    

    //Updates the position of the piece on the board.
    public void updatePos(int rowStart, int colStart, int rowEnd, int colEnd) {
        takesPiece = false;
        if (color.equals("white")) {
            board.addCapture("white", board.getPiece(rowEnd, colEnd));
        }
        else {
            board.addCapture("black", board.getPiece(rowEnd, colEnd));
        }
        this.getBoard().setPiece(null, rowStart, colStart);
        this.getBoard().setPiece(this, rowEnd, colEnd);      
    }

    //Checks if piece can be released on selected board position
    protected boolean canRelease(int rowEnd, int colEnd) {
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
        return false;
    }

    //Checks if piece is in bounds of Board array.
    protected boolean isInBounds(int rowEnd, int colEnd) {
        return rowEnd >= 0 && rowEnd < 8 && colEnd >= 0 && colEnd < 8;
    }

    //Checks if piece is taking a piece.
    public boolean takesPiece() {
        return takesPiece;
    }

    //Determines the direction of the piece
    public void handleDirection(int rowStart, int colStart, int rowEnd, int colEnd) {
        if (rowEnd > rowStart) {
            vDirection = "down";
        }
        else if(rowEnd < rowStart) {
            vDirection = "up";
        }

        if (colEnd > colStart) {
            hDirection = "right";
        }
        else if (colEnd < colStart) {
            hDirection = "left";
        }
    }

     //Check for pieces inbetween start and end positions for straight movement.
    public boolean checkStraightMovement(int rowStart, int colStart, int rowEnd, int colEnd) {
        if (rowEnd == rowStart) {
            //Check if rook is moving horizontally
            if (hDirection.equals("right")) {
                //Checks if squares leading to the released square is empty
                for (int c = colStart+1; c < colEnd; c++) {
                    if (board.getPiece(rowStart, c) != null) {
                        return false;
                    }
                }
                return canRelease(rowEnd, colEnd);
            }
            if (hDirection.equals("left")) { 
                //Checks if the squares leading to the released square is empty
                for(int c = colStart-1; c > colEnd; c--) {
                    if (board.getPiece(rowStart, c) != null) {
                        return false;
                    }
                }
                return canRelease(rowEnd, colEnd);
            }
        }

        if (colEnd == colStart) { 
            //Check If Rook Can Move Vertically 
            if (vDirection.equals("down")) {
                //Checks if the squares leading to the released square is empty
                for (int r = rowStart+1; r < rowEnd; r++) {
                    if (board.getPiece(r, colStart) != null) {
                        return false;
                    }
                }

                return canRelease(rowEnd, colEnd);
            }

            if (vDirection.equals("up")) {
                //Checks if the squares leading to the released square is empty
                for (int r = rowStart-1; r > rowEnd; r--) {
                    if (board.getPiece(r, colStart) != null) {
                        return false;
                    }
                }

                return canRelease(rowEnd, colEnd);
            }
        }
        return false;
    }
    
    //Check for pieces inbetween start and end positions for diagonal movement.
    public boolean checkDiagonalMovement(int rowStart, int colStart, int rowEnd, int colEnd) {
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

    //Calculates the distance change of a piece between the start and end positions
    public void calcDistanceChange(int rowStart, int colStart, int rowEnd, int colEnd) {
        vChange = Math.abs(rowEnd - rowStart);
        hChange = Math.abs(colEnd - colStart);
    }

    //Checks if a piece can move to the new position
    public abstract boolean canMove(int rowStart, int colStart, int rowEnd, int colEnd);

    //Returs piece to a string representation
    public abstract String toString();
}
