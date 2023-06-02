import javafx.beans.value.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;

public class Unit2Project extends Application {
	/*Declare variable for password generation type*/
	private int genTypeSelection;
	public static void main(String[] args) {
        launch();
    }

	/*defining a function to generate a random string of length l*/
	static String stringGen() {
		/*a list of characters to choose from in form of a string*/
		String characterGenSet = "1234567890!@#$%^&*";

		/*creating a StringBuffer size of characterGenSet*/
		StringBuilder s = new StringBuilder();
		int i;
		for (i=0; i<5; i++) {
			/*generating a random number using math.random() with a range spanning characterGenSet.length()*/
			int ch = (int)(characterGenSet.length() * Math.random());

			/*adding Random character one by one at the end of s*/
			s.append(characterGenSet.charAt(ch));
		}
		return s.toString();
	}
		

    @Override
	@SuppressWarnings("rawtypes")
    public void start(Stage stage) {

        stage.setTitle("Password Generator");
		/*creates a GridPlane object, grid is the variable name.*/
        GridPane grid = new GridPane(); 

		/*call setAlignment method*/
		grid.setAlignment(Pos.CENTER);

        /*calls setHgap method*/
		grid.setHgap(10); 
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		ChoiceBox<String> genType = new ChoiceBox<String>(FXCollections.observableArrayList("Shuffle", "MD5"));
		genType.getSelectionModel().selectFirst();
		genType.setValue(genType.getSelectionModel().getSelectedItem());
		grid.add(genType, 0, 0);

		genType.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() { 
			public void changed(ObservableValue ov, Number value, Number new_value) {
				genTypeSelection = new_value.intValue();
			};
		});
		/*creates a Text object, sceneTitle is the variable name.*/
		Text sceneTitle = new Text("Generate a secure password");
		grid.add(sceneTitle, 0, 1, 2, 1); //calls the add method

		/*creates a Label object, adjLabel is the variable name.*/
		Label adjLabel = new Label("Adjective");
		grid.add(adjLabel, 0, 2);

        /*creates a TextField object, pwBox is the variable name.*/
		TextField userAdj = new TextField(); 
		grid.add(userAdj, 1, 2);

		/*creates a Label object, userName is the variable name.*/
		Label animalLabel = new Label("Animal");
		grid.add(animalLabel, 0, 3);

		/*creates a TextField object, userAnimal is the variable name.*/
		TextField userAnimal = new TextField(); 
		grid.add(userAnimal, 1, 3);

		/*creates Button Object, btn in the variable name.*/
		Button btn = new Button("Generate");
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String uAnimal = userAnimal.getText();
				String uAdj = userAdj.getText();
				if (genTypeSelection == 0) {
					/*Split user inputs in two*/
					int splitAdj = uAdj.length()/2;
					int splitAnimal = uAnimal.length()/2;

					/*Swap order of first and second half of their string inputs*/
					String shuffleAdj = uAdj.substring(splitAdj) + uAdj.substring(0, splitAdj);
					String shuffleAnimal = uAnimal.substring(splitAnimal) + uAnimal.substring(0, splitAnimal);

					/*combine and display shuffled input and add random generated string*/
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText(shuffleAdj + shuffleAnimal + stringGen());
				}
				else {
					String userPw = uAdj + uAnimal;
					String encryptedUserPw = null;
					try {
						/* MessageDigest instance for MD5. */  
						MessageDigest m = MessageDigest.getInstance("MD5");  
				  
						/* Add plain-text password bytes to digest using MD5 update() method. */  
						m.update(userPw.getBytes());  
						  
						/* Convert the hash value into bytes */   
						byte[] bytes = m.digest();  
						  
						/* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
						StringBuilder s = new StringBuilder();  
						for(int i=0; i< bytes.length ;i++)  {
							s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
						}
						encryptedUserPw = s.toString();
					}
					catch (NoSuchAlgorithmException x) {
						x.printStackTrace();
					}
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText(encryptedUserPw);
				}		
			}
		});
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT); 
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);

		Scene scene = new Scene(grid, 300, 275);
		scene.getStylesheets().add("CSS/Unit2.css");
		stage.setScene(scene);
		stage.show();
    }

}
