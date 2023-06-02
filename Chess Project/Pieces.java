public abstract class Pieces{
    
    protected static Board board;
    protected boolean takesPiece = false;
    protected String color = "";

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

    //Checks if a piece can move to the new position
    public abstract boolean canMove(int rowStart, int colStart, int rowEnd, int colEnd);

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

    public abstract String toString();
}
