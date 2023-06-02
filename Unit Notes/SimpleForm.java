//Code from docs.oracle.com/javafx/2/get_standard/form.htm

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


/*
Vocabulary

-object: instance of a class

-attribute property: Attributes are variables defined in the class. They are almost declared as private (occasionally they are declared as public)

-null: Automatically given to objects when we declare but don't recognize them. We can also set objects to null. Calling methods on a null object results in an error.

-return type: datatype of what a non-void method.

-method: A named section of code that can be called.

-constructor: Like a method, but it isn't a method. Creates a new object.

-parameter: What is in () after a method name. They give information to the method being called.

-overloading constructors: When there's more than one constructor class. The number or the type and order of parameters must be different for each constructor.

-void methods: Methods that don't return a  value.

-non-void method: A method that returns value (like answering a question).
*/

public class SimpleForm extends Application 
{
	public static void main(String[] args) {
        launch();
    }

    @Override
	@SuppressWarnings("rawtypes")
    public void start(Stage stage) 
    {
        stage.setTitle("JavaFX Welcome");
        
        GridPane grid = new GridPane();//creates a GridPlane object, grid is the variable name.
		grid.setAlignment(Pos.CENTER);//call setAlignment method
		grid.setHgap(10);//calls setHgap method
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text sceneTitle = new Text("Hello");//creates a Text object, sceneTitle is the variable name.
		grid.add(sceneTitle, 0, 1, 2, 1);//calls the add method

		final String[] greetings = new String[]{"Hello", "Hola", "Привет", "こんにちは"};
		final ChoiceBox<String> langSelector = new ChoiceBox<String>(FXCollections.observableArrayList("English", "Español", "Pусский", "日本語"));
		langSelector.getSelectionModel().selectFirst();
		langSelector.setValue(langSelector.getSelectionModel().getSelectedItem());
		grid.add(langSelector, 0, 0);
		langSelector.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() { 
			public void changed(ObservableValue ov, Number value, Number new_value) {
				sceneTitle.setText(greetings[new_value.intValue()]);
			};
		});

		Label userName = new Label("User Name:"); //creates a Label object, userName is the variable name.
		grid.add(userName, 0, 2);

		TextField userTextField = new TextField(); //creates a TextField object, userTextField is the variable name.
		grid.add(userTextField, 1, 2);

		Label pw = new Label("Password:"); //creates a Label object, pw is the variable name.
		grid.add(pw, 0, 3);

		PasswordField pwBox = new PasswordField(); //creates a PasswordField object, pwBox is the variable name.
		grid.add(pwBox, 1, 3);
			
		Button btn = new Button("Sign in");//creates Button Object, btn in the variable name.
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("Sign in button pressed");
			}
		});
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT); 
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);

		Scene scene = new Scene(grid, 300, 275);
		stage.setScene(scene);
			stage.show();
    }

}
