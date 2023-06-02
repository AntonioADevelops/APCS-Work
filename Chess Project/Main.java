import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Main extends Application{

    private Board board = new Board();
    private GridPane gridPane = new GridPane();
    private double startX;
    private double startY;
    private int[] indexStart = new int[2];
    private Pieces clickedPiece;
    
    
    private Node getPieceNode(int row, int column) {
        Node result = null;
        ObservableList<Node> children = gridPane.getChildren();
        // 0th child = gridLine visiblity
        // 1st -> 64th child = board tiles
        // 65th child = first piece
        for (int i = 65; i < children.size(); i++) { 
            Node node = children.get(i);
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }

    private void makeDraggable(Node node) {
        

        node.setOnMousePressed(e -> {
            startX = e.getSceneX() - node.getTranslateX();
            startY = e.getSceneY() - node.getTranslateY();

            indexStart[0] = GridPane.getRowIndex(node);
            indexStart[1] = GridPane.getColumnIndex(node);
            clickedPiece = board.getPiece(indexStart[0], indexStart[1]);
            
            // System.out.println(indexStart[0] + ", " + indexStart[1]);

        });

    
        node.setOnMouseDragged(e -> {
            node.setTranslateX(e.getSceneX() - startX);
            node.setTranslateY(e.getSceneY() - startY);
        });

        node.setOnMouseReleased(e -> {
            node.setTranslateX(0);
            node.setTranslateY(0);

            int[] indexReleased = new int[2];  
            int columnReleased = (int) (e.getSceneX() - 75) / 100;
            int rowReleased = (int) (e.getSceneY() - 75) / 100;
            indexReleased[0] = rowReleased;
            indexReleased[1] = columnReleased;

            // System.out.println(rowReleased + ", " + columnReleased);
            
            if(clickedPiece.canMove(indexStart[0], indexStart[1], indexReleased[0], indexReleased[1]))
            {
                if (clickedPiece.takesPiece()) {
                    if (clickedPiece instanceof Pawn && ((Pawn) clickedPiece).doesEnpassant()) {
                        
                        if (clickedPiece.getColor().equals("white")) {
                            gridPane.getChildren().remove(getPieceNode(rowReleased+1, columnReleased));
                        }

                        else {
                            gridPane.getChildren().remove(getPieceNode(rowReleased-1, columnReleased));
                        }
                    }
                    else {
                        gridPane.getChildren().remove(getPieceNode(rowReleased, columnReleased));
                    }          
                }
                clickedPiece.updatePos(indexStart[0], indexStart[1], indexReleased[0], indexReleased[1]);
                gridPane.getChildren().remove(node);
                gridPane.add(node, indexReleased[1], indexReleased[0]);
                GridPane.setHalignment(node, HPos.CENTER);
            }
            
            // System.out.println(board);
        });

    }

    private void createPieces() {
        //Create Pieces
        //Black Pieces
        Image rookB = new Image("CSS/rookB.png");
        Image knightB = new Image("CSS/knightB.png");
        Image bishopB= new Image("CSS/bishopB.png");
        Image queenB = new Image("CSS/queenB.png");
        Image kingB = new Image("CSS/kingB.png");
        Image pawnB = new Image("CSS/pawnB.png");

        ImageView[][] blackPieces = new ImageView[2][8];

        //Black Rook 1
        ImageView rookViewB1 = new ImageView();
        rookViewB1.setImage(rookB);
        blackPieces[0][0] = rookViewB1;

        //Black Knight 1
        ImageView knightViewB1 = new ImageView();
        knightViewB1.setImage(knightB);
        blackPieces[0][1] = knightViewB1;

        //Black Bishop 1
        ImageView bishopViewB1 = new ImageView();
        bishopViewB1.setImage(bishopB);
        blackPieces[0][2] = bishopViewB1;

        //Black Queen
        ImageView queenViewB = new ImageView();
        queenViewB.setImage(queenB);
        blackPieces[0][3] = queenViewB;

        //Black King
        ImageView kingViewB = new ImageView();
        kingViewB.setImage(kingB);
        blackPieces[0][4] = kingViewB;    

        //Black Bishop 2
        ImageView bishopViewB2 = new ImageView();
        bishopViewB2.setImage(bishopB);
        blackPieces[0][5] = bishopViewB2;

        //Black Knight 2
        ImageView knightViewB2 = new ImageView();
        knightViewB2.setImage(knightB);
        blackPieces[0][6] = knightViewB2;

        //Black Rook 2
        ImageView rookViewB2 = new ImageView();
        rookViewB2.setImage(rookB);
        blackPieces[0][7] = rookViewB2;

        //Black Pawn 1
        ImageView pawnViewB1 = new ImageView();
        pawnViewB1.setImage(pawnB);
        blackPieces[1][0] = pawnViewB1;

        //Black Pawn 2
        ImageView pawnViewB2 = new ImageView();
        pawnViewB2.setImage(pawnB);
        blackPieces[1][1] = pawnViewB2;

        //Black Pawn 3
        ImageView pawnViewB3 = new ImageView();
        pawnViewB3.setImage(pawnB);
        blackPieces[1][2] = pawnViewB3;

        //Black Pawn 4
        ImageView pawnViewB4 = new ImageView();
        pawnViewB4.setImage(pawnB);
        blackPieces[1][3] = pawnViewB4;

        //Black Pawn 5
        ImageView pawnViewB5 = new ImageView();
        pawnViewB5.setImage(pawnB);
        blackPieces[1][4] = pawnViewB5;

        //Black Pawn 6
        ImageView pawnViewB6 = new ImageView();
        pawnViewB6.setImage(pawnB);
        blackPieces[1][5] = pawnViewB6;

        //Black Pawn 7
        ImageView pawnViewB7 = new ImageView();
        pawnViewB7.setImage(pawnB);
        blackPieces[1][6] = pawnViewB7;

        //Black Pawn 8
        ImageView pawnViewB8 = new ImageView();
        pawnViewB8.setImage(pawnB);
        blackPieces[1][7] = pawnViewB8;

        //White Pieces
        Image rookW = new Image("CSS/rookW.png");
        Image knightW = new Image("CSS/knightW.png");
        Image bishopW = new Image("CSS/bishopW.png");
        Image queenW = new Image("CSS/queenW.png");
        Image kingW = new Image("CSS/kingW.png");
        Image pawnW = new Image("CSS/pawnW.png");

        ImageView[][] whitePieces = new ImageView[2][8];

        //White Rook 1
        ImageView rookViewW1 = new ImageView();
        rookViewW1.setImage(rookW);
        whitePieces[1][0] = rookViewW1;

        //White Knight 1
        ImageView knightViewW1 = new ImageView();
        knightViewW1.setImage(knightW);
        whitePieces[1][1] = knightViewW1;
        
        //White Bishop 1
        ImageView bishopViewW1 = new ImageView();
        bishopViewW1.setImage(bishopW);
        whitePieces[1][2] = bishopViewW1;

        //White Queen
        ImageView queenViewW = new ImageView();
        queenViewW.setImage(queenW);
        whitePieces[1][3] = queenViewW;

        //White King
        ImageView kingViewW = new ImageView();
        kingViewW.setImage(kingW);
        whitePieces[1][4] = kingViewW;

        //White Bishop 2
        ImageView bishopViewW2 = new ImageView();
        bishopViewW2.setImage(bishopW);
        whitePieces[1][5] = bishopViewW2;

        //White Knight 2
        ImageView knightViewW2 = new ImageView();
        knightViewW2.setImage(knightW);
        whitePieces[1][6] = knightViewW2;

        //White Rook 2
        ImageView rookViewW2 = new ImageView();
        rookViewW2.setImage(rookW);
        whitePieces[1][7] = rookViewW2;

        //White Pawns 1
        ImageView pawnViewW1 = new ImageView();
        pawnViewW1.setImage(pawnW);
        whitePieces[0][0] = pawnViewW1;

        //White Pawns 2
        ImageView pawnViewW2 = new ImageView();
        pawnViewW2.setImage(pawnW);
        whitePieces[0][1] = pawnViewW2;

        //White Pawns 3
        ImageView pawnViewW3 = new ImageView();
        pawnViewW3.setImage(pawnW);
        whitePieces[0][2] = pawnViewW3;

        //White Pawns 4
        ImageView pawnViewW4 = new ImageView();
        pawnViewW4.setImage(pawnW);
        whitePieces[0][3] = pawnViewW4;

        //White Pawns 5
        ImageView pawnViewW5 = new ImageView();
        pawnViewW5.setImage(pawnW);
        whitePieces[0][4] = pawnViewW5;

        //White Pawns 6
        ImageView pawnViewW6 = new ImageView();
        pawnViewW6.setImage(pawnW);
        whitePieces[0][5] = pawnViewW6;

        //White Pawns 7
        ImageView pawnViewW7 = new ImageView();
        pawnViewW7.setImage(pawnW);
        whitePieces[0][6] = pawnViewW7;

        //White Pawns 8
        ImageView pawnViewW8 = new ImageView();
        pawnViewW8.setImage(pawnW);
        whitePieces[0][7] = pawnViewW8;
        
        //Add Pieces to Board
        //Add Black Pieces to Board
        for(int r = 0; r < 2; r++) {
            for(int c = 0; c < 8; c++) {
                gridPane.add(blackPieces[r][c], c, r);
                GridPane.setHalignment(blackPieces[r][c], HPos.CENTER);
                makeDraggable(blackPieces[r][c]);
            }
        }

        //Add White Pieces to Board
        for(int r = 0; r < 2; r++) {
            for(int c = 0; c < 8; c++) {
                gridPane.add(whitePieces[r][c], c, r+6);
                GridPane.setHalignment(whitePieces[r][c], HPos.CENTER);
                makeDraggable(whitePieces[r][c]);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Chess In Java");
        int sceneHeightnWidth = 950;

        Color b = Color.web("#769656");
        Color w = Color.web("#eeeed2");

        //Create Board and Display  
        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #FFFFFF;");
        int count = 1;
        for (int r = 0; r < 8; r++) {
            count++;
            for (int c = 0; c < 8; c++) {
                Rectangle x = new Rectangle(100, 100);
                if (count % 2 == 0) {
                    x.setFill(w);                
                }
                else {
                    x.setFill(b);
                }
                gridPane.add(x, c, r);
                count++;
            }
        }
        //Assign squares to board
        Pieces.setBoard(board);

        //Creates Pieces
        createPieces();
        
        //Set color of pieces in 2dArray
        //Set Pieces Black
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 8; c++) {
                board.getPiece(r, c).setColor("black");
            }
        }

        //Set Pieces White
        for (int r = 6; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                board.getPiece(r, c).setColor("white");
            }
        }

        primaryStage.setResizable(false);
        Scene scene = new Scene(gridPane, sceneHeightnWidth, sceneHeightnWidth);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
