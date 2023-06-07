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
        resetBoard();
        updateChecks();
    }

    public void updateChecks() { 
        resetChecks();
        for (int r = 0; r < board.length; r ++) {
            for (int c = 0; c < board[r].length; c++) {
                handlePawnChecks(r, c);
                handleBishopChecks(r, c); 
            }
        }
    }

    private void resetChecks() {
        for (int r = 0; r < board.length; r ++) {
            for (int c = 0; c < board[r].length; c++) {
                dangerB[r][c] = false;
                dangerW[r][c] = false;
            }
        }
    }

    private void handlePawnChecks(int r, int c) {
        boolean inBounds = r > 0 && r < 7 && c > 0 && c < 7;        
        if (board[r][c] instanceof Pawn && inBounds && board[r][c].getColor().equals("white")) {
                dangerW[r-1][c-1] = true;
                dangerW[r-1][c+1] = true;
            }

        if (board[r][c] instanceof Pawn && inBounds && board[r][c].getColor().equals("black")) {
            dangerB[r+1][c-1] = true;
            dangerB[r+1][c+1] = true;
        }
    }

    private void handleBishopChecks(int r, int c) {   
        int tempR = r;
        int tempC = c;
        if (board[r][c] instanceof Bishop) {
            //Sets true until downward-right diagnonal path is blocked by a piece or reaches end of board.
            while (r+1 >= 0 && r+1 <= 7 && c+1 >= 0 && c+1 <= 7 && board[r+1][c+1] == null){
                if (board[tempR][tempC].getColor().equals("white")) {
                    dangerW[r+1][c+1] = true;
                }

                if (board[tempR][tempC].getColor().equals("black")) {
                    dangerB[r+1][c+1] = true;
                }
                r++;
                c++;      
            }

            if (r+1 >= 0 && r+1 <= 7 && c+1 >= 0 && c+1 <= 7 && board[r+1][c+1] != null) {
                if (board[tempR][tempC].getColor().equals("white")) {
                    dangerW[r+1][c+1] = true;
                }

                if (board[tempR][tempC].getColor().equals("black")) {
                    dangerB[r+1][c+1] = true;
                }
            }

            r = tempR;
            c = tempC;
            //Sets true until upwards-right diagnonal path is blocked by a piece or reaches end of board.
            while (r-1 >= 0 && r-1 <= 7 && c+1 >= 0 && c+1 <= 7 && board[r-1][c+1] == null){
                if (board[tempR][tempC].getColor().equals("white")) {
                    dangerW[r-1][c+1] = true;
                }

                if (board[tempR][tempC].getColor().equals("black")) {
                    dangerB[r-1][c+1] = true;
                }
                r--;
                c++;
            }

            System.out.println(r + ", " + c);

            if (r-1 >= 0 && r-1 <= 7 && c+1 >= 0 && c+1 <= 7 && board[r-1][c+1] != null) {
                if (board[tempR][tempC].getColor().equals("white")) {
                    dangerW[r-1][c+1] = true;
                }

                if (board[tempR][tempC].getColor().equals("black")) {
                    dangerB[r-1][c+1] = true;
                }
            }

            r = tempR;
            c = tempC;
            //Sets true until downwards-left diagnonal path is blocked by a piece or reaches end of board.
            while (r+1 >= 0 && r+1 <= 7 && c-1 >= 0 && c-1 <= 7 && board[r+1][c-1] == null){
                if (board[tempR][tempC].getColor().equals("white")) {
                    dangerW[r+1][c-1] = true;
                }

                if (board[tempR][tempC].getColor().equals("black")) {
                    dangerB[r+1][c-1] = true;
                }
                
                r++;
                c--;
            }

            if (r+1 >= 0 && r+1 <= 7 && c-1 >= 0 && c-1 <= 7 && board[r+1][c-1] != null) {
                if (board[tempR][tempC].getColor().equals("white")) {
                    dangerW[r+1][c-1] = true;
                }

                if (board[tempR][tempC].getColor().equals("black")) {
                    dangerB[r+1][c-1] = true;
                }
            }

            r = tempR;
            c = tempC;
            //Sets true until upwards-left diagnonal path is blocked by a piece or reaches end of board.
            while (r-1 >= 0 && r-1 <= 7 && c-1 >= 0 && c-1 <= 7 && board[r-1][c-1] == null){
                if (board[tempR][tempC].getColor().equals("white")) {
                    dangerW[r-1][c-1] = true;
                }

                if (board[tempR][tempC].getColor().equals("black")) {
                    dangerB[r-1][c-1] = true;
                }
                r--;
                c--;
            }

            if (r-1 >= 0 && r-1 <= 7 && c-1 >= 0 && c-1 <= 7 && board[r-1][c-1] != null) {
                if (board[tempR][tempC].getColor().equals("white")) {
                    dangerW[r-1][c-1] = true;
                }

                if (board[tempR][tempC].getColor().equals("black")) {
                    dangerB[r-1][c-1] = true;
                }
            }

            r = tempR;
            c = tempC;
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
    
    public boolean getDangerW(int r, int c) {
        return dangerW[r][c];
    }

    public boolean getDangerB(int r, int c) {
        return dangerB[r][c];
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

    public void printDangerW() {
        for (int r = 0; r < board.length; r ++) {
            for (int c = 0; c < board[r].length; c++) {
                System.out.print(dangerW[r][c] + " ");
            }
            System.out.println();
        }
       
    }

    public void printDangerB() {
        for (int r = 0; r < board.length; r ++) {
            for (int c = 0; c < board[r].length; c++) {
                System.out.print(dangerB[r][c] + " ");
            }
            System.out.println();
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
