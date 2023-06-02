public class Pawn extends Pieces{

    boolean hasMoved = false;
    boolean canEnpassant = false;
    boolean doesEnpassant = false;
    
    public Pawn() {

    }

    //index[0] = row Index
    //index[1] = column Index
    public boolean canMove(int rowStart, int colStart, int rowEnd, int colEnd) {

        // Pieces forwardSquareW = board.getPiece(rowStart-1, colStart);
        // Pieces forwardTwoSquareW = board.getPiece(rowStart-2, colStart);
        // Pieces diagonalLeftSquareW = board.getPiece(rowStart-1, colStart-1);
        // Pieces diagonalRightSquareW = board.getPiece(rowStart-1, colStart+1);

        // Pieces forwardSquareB = board.getPiece(rowStart+1, colStart);
        // Pieces forwardTwoSquareB = board.getPiece(rowStart+2, colStart);
        // Pieces diagonalLeftSquareB = board.getPiece(rowStart+1, colStart-1);
        // Pieces diagonalRightSquareB = board.getPiece(rowStart+1, colStart+1);

        //Base Movements
        if (color.equals("white")) {
            
            //Forward Movement
            if (rowEnd == rowStart-1 && colEnd == colStart && board.getPiece(rowStart-1, colStart) == null) {
                canEnpassant = false;
                return true;
            }

            //Forward Two Movement
            if (!hasMoved) {
                if (rowEnd == rowStart-2 && colEnd == colStart && board.getPiece(rowStart-1, colStart) == null && board.getPiece(rowStart-2, colStart) == null) {
                    canEnpassant = true;
                    return true;
                }
            }

            if (colStart >= 0 && colStart < 7) {
                if (rowEnd == rowStart-1 && colEnd == colStart+1) {
                    //Diagonal Right Movement
                    if (board.getPiece(rowStart-1, colStart+1) != null) { 
                        if (board.getPiece(rowEnd, colEnd).getColor().equals("black")) {
                            takesPiece = true;
                            return true;
                        }   
                    }

                    //Enpassant Right Movement
                    if (board.getPiece(rowStart, colStart+1) instanceof Pawn && ((Pawn) board.getPiece(rowStart, colStart+1)).canEnpassant()) {
                        if (board.getPiece(rowEnd+1, colEnd).getColor().equals("black")) {
                            doesEnpassant = true;
                            takesPiece = true;
                            return true;
                        }
                    }
                }  
            }


            if (colStart <= 7) { 
                if (rowEnd == rowStart-1 && colEnd == colStart-1) {
                    
                    //Diagonal Left Movement
                    if (board.getPiece(rowStart-1, colStart-1) != null) { 
                        if (board.getPiece(rowEnd, colEnd).getColor().equals("black")) {
                            takesPiece = true;
                            return true;
                        }
                    }

                    //Enpassant Left Movement
                    if (board.getPiece(rowStart, colStart-1) instanceof Pawn && ((Pawn) board.getPiece(rowStart, colStart-1)).canEnpassant()) {
                        if (board.getPiece(rowEnd+1, colEnd).getColor().equals("black")) {
                            doesEnpassant = true;
                            takesPiece = true;
                            return true;
                        }
                    }
                }
            } 
        }

        if (color.equals("black")) {
            
            //Forward Movement
            if (rowEnd == rowStart+1 && colEnd == colStart && board.getPiece(rowStart+1, colStart) == null) {
                canEnpassant = false;;
                return true;
            }

            //Forward Two Movement
            if (!hasMoved) {
                if (rowEnd == rowStart+2 && colEnd == colStart && board.getPiece(rowStart+1, colStart) == null && board.getPiece(rowStart+2, colStart) == null) {
                    canEnpassant = true;
                    return true;
                }
            }

            if (colStart >= 0 && colStart < 7) {
                if (rowEnd == rowStart+1 && colEnd == colStart+1) {
                    
                    //Diagonal Right Movement
                    if (board.getPiece(rowStart+1, colStart+1) != null) { 
                        if (board.getPiece(rowEnd, colEnd).getColor().equals("white")){
                            takesPiece = true;
                            return true;
                        }
                    }
     
                    //Enpassant Right Movement
                    if (board.getPiece(rowStart, colStart+1) instanceof Pawn && ((Pawn) board.getPiece(rowStart, colStart+1)).canEnpassant()) {
                        if (board.getPiece(rowEnd-1, colEnd).getColor().equals("white")) {
                            doesEnpassant = true;
                            takesPiece = true;
                            return true;
                        }
                    }
                }
            }

            if (colStart <= 7) {
                if (rowEnd == rowStart+1 && colEnd == colStart-1) {
                    
                    //Diagonal Left Movement
                    if (board.getPiece(rowStart+1, colStart-1) != null) { 
                        if (board.getPiece(rowEnd, colEnd).getColor().equals("white")) {
                            takesPiece = true;
                            return true;
                        }
                    }
                   
                    //Enpassant Left Movement
                    if (board.getPiece(rowStart, colStart-1) instanceof Pawn && ((Pawn) board.getPiece(rowStart, colStart-1)).canEnpassant()) {
                        if (board.getPiece(rowEnd-1, colEnd).getColor().equals("white")) {
                            doesEnpassant = true;
                            takesPiece = true;
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    public void updatePos(int[] indexStart, int[] indexReleased) {
        hasMoved = true;
        takesPiece = false;
        board.setPiece(null, indexStart[0], indexStart[1]);
        board.setPiece(this, indexReleased[0], indexReleased[1]);
        
        if (doesEnpassant) {
            if (color.equals("white")) {
                board.addCapture("white", board.getPiece(indexReleased[0]+1, indexReleased[1]));
                board.setPiece(null, indexReleased[0]+1, indexReleased[1]);
                
            }
            else {
                board.addCapture("black", board.getPiece(indexReleased[0]-1, indexReleased[1]));
                board.setPiece(null, indexReleased[0]-1, indexReleased[1]);
            }
            
        }
        doesEnpassant =false;
    }

    public boolean canEnpassant() {
        return canEnpassant;
    }

    public boolean doesEnpassant() {
        return doesEnpassant;
    }

    public String toString(){
        return "Pawn";
    }
}
