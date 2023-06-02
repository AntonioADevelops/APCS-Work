import java.util.ArrayList;

public class Board {

    private Pieces[][] board = new Pieces[8][8];
    
    // Squared being attacked by black pieces. True if it is attacked, false otherwise
    private boolean[][] dangerB = new boolean[8][8];

    // Squares being attacked by white pieces. True if it is attacked, false otherwise
    private boolean[][] dangerW = new boolean[8][8];
    
    private ArrayList<Pieces> capturedBlack = new ArrayList<Pieces>();
    private ArrayList<Pieces> capturedWhite = new ArrayList<Pieces>();

    public Board() {
        for (int r = 1; r < board.length; r += 5) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = new Pawn();
            }
        }

        for (int r = 0; r < board.length; r += 7) {
            int col = 0;
            board[r][col] = new Rook();
            col++;
            board[r][col] = new Knight();
            col++;
            board[r][col] = new Bishop();
            col++;
            board[r][col] = new Queen();
            col++;
            board[r][col] = new King();
            col++;
            board[r][col] = new Bishop();
            col++;
            board[r][col] = new Knight();
            col++;
            board[r][col] = new Rook();
            col++;
        }
    }

    public void resetBoard() {
        for (int r = 1; r < board.length; r += 5) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = new Pawn();
            }
        }
        
        for (int r = 0; r < board.length; r += 7) {
            int col = 0;
            board[r][col] = new Rook();
            col++;
            board[r][col] = new Knight();
            col++;
            board[r][col] = new Bishop();
            col++;
            board[r][col] = new Queen();
            col++;
            board[r][col] = new King();
            col++;
            board[r][col] = new Bishop();
            col++;
            board[r][col] = new Knight();
            col++;
            board[r][col] = new Rook();
            col++;
        }
    }

    public Pieces getPiece(int r, int c) {
        return board[r][c];
    }

    public void setPiece(Pieces piece, int r, int c) {
        board[r][c] = piece;
    }

    public void addCapture (String capturedPieceColor, Pieces piece) {
        if (capturedPieceColor.equals("white")) {
            capturedWhite.add(piece);
        } 

        else {
            capturedBlack.add(piece);
        }
    }

    public ArrayList<Pieces> getCaptured(String color) {
        if (color.equals("white")) {
            return capturedWhite;
        }
        
        else {
            return capturedBlack;
        }
    }

    public String toString() {
        String boardS = "";
        for(Pieces[] x: board) {
            for(Pieces y: x) {
                boardS += y + " ";
            }
            boardS += "\n";
        }
        return boardS;
    }
}
