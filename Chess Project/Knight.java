public class Knight extends Pieces {
    
    public String toString() {
        return "Knight";
    }

    //index[0] = row Index
    //index[1] = column Index
    public boolean canMove(int rowStart, int colStart, int rowEnd, int colEnd) {
        // Pieces up2 left1 = super.getBoard().getPiece(rowStart-2, colStart+1);
        // Pieces up2 right1 = super.getBoard().getPiece(rowStart-2, colStart-1);
        // Pieces down2 left1 = super.getBoard().getPiece(rowStart-1, colStart-1);
        // Pieces down2 right1 = super.getBoard().getPiece(rowStart-1, colStart+1);
        // Pieces left2 up1= super.getBoard().getPiece(rowStart+1, colStart);
        // Pieces left2 down1 = super.getBoard().getPiece(rowStart+2, colStart);
        // Pieces right2 up1 = super.getBoard().getPiece(rowStart+1, colStart-1);
        // Pieces right2 down1 = super.getBoard().getPiece(rowStart+1, colStart+1);

        //Up2 Right1
        if (rowEnd == rowStart-2 && colEnd == colStart+1) { 
            if (board.getPiece(rowEnd, colEnd) == null) {
                return true;
            }
            if (board.getPiece(rowEnd, colEnd) != null) {
                if(color.equals("white") && board.getPiece(rowEnd, colEnd).getColor().equals("black")) {
                    takesPiece = true;
                    return true;
                }

                if (color.equals("black") && board.getPiece(rowEnd, colEnd).getColor().equals("white")) {
                    takesPiece = true;
                    return true;
                }
            }
        }

        //Up2 Left1
        if (rowEnd == rowStart-2 && colEnd == colStart-1) {
            if (board.getPiece(rowEnd, colEnd) == null) {
                return true;
            }
            if (board.getPiece(rowEnd, colEnd) != null) {
                if(color.equals("white") && board.getPiece(rowEnd, colEnd).getColor().equals("black")) {
                    takesPiece = true;
                    return true;
                }

                if (color.equals("black") && board.getPiece(rowEnd, colEnd).getColor().equals("white")) {
                    takesPiece = true;
                    return true;
                }
            }
        }

        //Down2 Right1
        if (rowEnd == rowStart+2 && colEnd == colStart+1) {
            if (board.getPiece(rowEnd, colEnd) == null) {
                return true;
            }
            if (board.getPiece(rowEnd, colEnd) != null) {
                if(color.equals("white") && board.getPiece(rowEnd, colEnd).getColor().equals("black")) {
                    takesPiece = true;
                    return true;
                }

                if (color.equals("black") && board.getPiece(rowEnd, colEnd).getColor().equals("white")) {
                    takesPiece = true;
                    return true;
                }
            }
        }

        //Down2 Left1
        if (rowEnd == rowStart+2 && colEnd == colStart-1) {
            if (board.getPiece(rowEnd, colEnd) == null) {
                return true;
            }
            if (board.getPiece(rowEnd, colEnd) != null) {
                if(color.equals("white") && board.getPiece(rowEnd, colEnd).getColor().equals("black")) {
                    takesPiece = true;
                    return true;
                }

                if (color.equals("black") && board.getPiece(rowEnd, colEnd).getColor().equals("white")) {
                    takesPiece = true;
                    return true;
                }
            }
        }

        //Left2 Up1
        if (rowEnd == rowStart-1 && colEnd == colStart-2) {
            if (board.getPiece(rowEnd, colEnd) == null) {
                return true;
            }
            if (board.getPiece(rowEnd, colEnd) != null) {
                if(color.equals("white") && board.getPiece(rowEnd, colEnd).getColor().equals("black")) {
                    takesPiece = true;
                    return true;
                }

                if (color.equals("black") && board.getPiece(rowEnd, colEnd).getColor().equals("white")) {
                    takesPiece = true;
                    return true;
                }
            }
        }

        //Left2 Down1
        if (rowEnd == rowStart+1 && colEnd == colStart-2) {
            if (board.getPiece(rowEnd, colEnd) == null) {
                return true;
            }
            if (board.getPiece(rowEnd, colEnd) != null) {
                if(color.equals("white") && board.getPiece(rowEnd, colEnd).getColor().equals("black")) {
                    takesPiece = true;
                    return true;
                }

                if (color.equals("black") && board.getPiece(rowEnd, colEnd).getColor().equals("white")) {
                    takesPiece = true;
                    return true;
                }
            }
        }

        //Right2 Up1
        if (rowEnd == rowStart-1 && colEnd == colStart+2) {
            if (board.getPiece(rowEnd, colEnd) == null) {
                return true;
            }
            if (board.getPiece(rowEnd, colEnd) != null) {
                if(color.equals("white") && board.getPiece(rowEnd, colEnd).getColor().equals("black")) {
                    takesPiece = true;
                    return true;
                }

                if (color.equals("black") && board.getPiece(rowEnd, colEnd).getColor().equals("white")) {
                    takesPiece = true;
                    return true;
                }
            }
        }

        //Right2 Down1
        if (rowEnd == rowStart+1 && colEnd == colStart+2) {
            if (board.getPiece(rowEnd, colEnd) == null) {
                return true;
            }
            if (board.getPiece(rowEnd, colEnd) != null) {
                if(color.equals("white") && board.getPiece(rowEnd, colEnd).getColor().equals("black")) {
                    takesPiece = true;
                    return true;
                }

                if (color.equals("black") && board.getPiece(rowEnd, colEnd).getColor().equals("white")) {
                    takesPiece = true;
                    return true;
                }
            }
        }
        return false;
    }   
}
