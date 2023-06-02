public abstract class Pieces{
    
    protected static Board board;
    protected boolean takesPiece = false;
    protected String color = "";
    
    public Pieces() {

    }

    public void setColor(String c) {
        color = c;
    }

    public String getColor() {
        return color;
    }

    public static void setBoard(Board b) {
        board = b;
    }

    public Board getBoard() {
        return board;
    }

    public abstract boolean canMove(int rowStart, int colStart, int rowEnd, int colEnd);

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

    protected boolean isTaking(int rowEnd, int colEnd) {
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

    public boolean takesPiece() {
        return takesPiece;
    }

    public abstract String toString();
}
