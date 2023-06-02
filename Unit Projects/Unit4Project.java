import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import javafx.scene.image.WritableImage;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Slider;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
 
public class Unit4Project extends Application {

    @Override
    public void start(Stage primaryStage) {
       
        ColorAdjust colorAdjust = new ColorAdjust();
        //Create Image and ImageView objects
        Image image = new Image("CSS/frog_50.jpeg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setEffect(colorAdjust);
       
        //Obtain PixelReader for loaded image
        PixelReader pixelReader = image.getPixelReader();
        System.out.println("Image Width: "+image.getWidth());
        System.out.println("Image Height: "+image.getHeight());
        System.out.println("Pixel Format: "+pixelReader.getPixelFormat());
       
        //Create WritableImage
        WritableImage wImage = new WritableImage((int)image.getWidth(), (int)image.getHeight());
        PixelWriter pixelWriter = wImage.getPixelWriter();


        //Get color value for each x at each y cordinate
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                pixelWriter.setColor(x, y, pixelReader.getColor(x, y));
            }
        }

        //Add Image to Scene
        imageView.setImage(wImage);
        Pane root = new Pane();
        root.getChildren().add(imageView);
        imageView.setLayoutX(360);
        imageView.setLayoutY(270);

        //Grid for Sliders
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(70);      
             
        //Creating Slider
        Slider hue = new Slider();
        Slider saturation = new Slider();
        Slider scaling = new Slider();
        Slider opacity = new Slider();

        //Creating Slider Labels
        Label hueCaption = new Label("Hue:");  
        Label saturationCaption = new Label("Saturation:");
        Label scalingCaption = new Label("Scaling:");
        Label opacityCaption = new Label("Opacity:");

        // Creating Slider Value Labels
        final Label hueValue = new Label(Double.toString(saturation.getValue()));
        final Label saturationValue = new Label(Double.toString(saturation.getValue()));
        final Label scalingValue = new Label(Double.toString(scaling.getValue()));
        final Label opacityValue = new Label(Double.toString(opacity.getValue()));
        
        //Add Opacity Objects to Scene
        opacityCaption.setTextFill(Color.BLACK);
        GridPane.setConstraints(opacityCaption, 0, 1);
        grid.getChildren().add(opacityCaption);

        GridPane.setConstraints(opacity, 1, 1);
        grid.getChildren().add(opacity);
 
        opacityValue.setTextFill(Color.BLACK);
        GridPane.setConstraints(opacityValue, 2, 1);
        grid.getChildren().add(opacityValue);

        //Change Opacity Value to Slider Value
        opacity.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                imageView.setOpacity(new_val.doubleValue()/100);
                opacityValue.setText(String.format("%.2f", new_val));
            }
        });
        opacity.setValue(100);

        //Button to set Opacity Value to Specific Value
        Button opacityButton = new Button();
        GridPane.setConstraints(opacityButton, 2, 1);
        grid.getChildren().add(opacityButton);

        opacityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                opacityValue.setStyle("-fx-visibility: hidden");
                TextField opacityManual = new TextField();
                GridPane.setConstraints(opacityManual, 2, 1);
                grid.getChildren().add(opacityManual);


                opacityManual.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        Double new_val = Double.parseDouble(opacityManual.getText());
                        if (new_val <= 100 && new_val >= 0) {
                            imageView.setOpacity(new_val/100);
                            opacityValue.setText(String.format("%.2f", new_val));
                            opacityValue.setStyle("-fx-visibility: visible");
                            grid.getChildren().remove(opacityManual);
                        } 
                    }
                });
            }
        });

        //Add Scaling Objects to Scene
        scalingCaption.setTextFill(Color.BLACK);
        GridPane.setConstraints(scalingCaption, 0, 2);
        grid.getChildren().add(scalingCaption);

        GridPane.setConstraints(scaling, 1, 2);
        grid.getChildren().add(scaling);
 
        scalingValue.setTextFill(Color.BLACK);
        GridPane.setConstraints(scalingValue, 2, 2);
        grid.getChildren().add(scalingValue);

        //Change Scaling Value to Slider Value
        scaling.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    imageView.setScaleX(new_val.doubleValue()/50);
                    imageView.setScaleY(new_val.doubleValue()/50);
                    scalingValue.setText(String.format("%.2f", new_val));
            }
        });
        scaling.setValue(50);

        //Button to set Scaling Value to Specific Value
        Button scalingButton = new Button();
        GridPane.setConstraints(scalingButton, 2, 2);
        grid.getChildren().add(scalingButton);

        scalingButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                scalingValue.setStyle("-fx-visibility: hidden");
                TextField scalingManual = new TextField();
                GridPane.setConstraints(scalingManual, 2, 2);
                grid.getChildren().add(scalingManual);


                scalingManual.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        Double new_val = Double.parseDouble(scalingManual.getText());
                        if (new_val <= 100 && new_val >= 0) {
                            imageView.setScaleX(new_val/50);
                            imageView.setScaleY(new_val/50);
                            scalingValue.setText(String.format("%.2f", new_val));
                            scalingValue.setStyle("-fx-visibility: visible");
                            grid.getChildren().remove(scalingManual);
                        } 
                    }
                });
            }
        });

        //Add Hue Objects to Scene
        hueCaption.setTextFill(Color.BLACK);
        GridPane.setConstraints(hueCaption, 0, 3);
        grid.getChildren().add(hueCaption);

        GridPane.setConstraints(hue, 1, 3);
        grid.getChildren().add(hue);
 
        hueValue.setTextFill(Color.BLACK);
        GridPane.setConstraints(hueValue, 2, 3);
        grid.getChildren().add(hueValue);

        //Change Hue Value to Slider Value
        hue.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    colorAdjust.setHue(new_val.doubleValue()/100);
                    hueValue.setText(String.format("%.2f", new_val));
            }
        });
        hue.setValue(0);
        
        //Button to set Hue Value to Specific Value
        Button hueButton = new Button();
        GridPane.setConstraints(hueButton, 2, 3);
        grid.getChildren().add(hueButton);

        hueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                hueValue.setStyle("-fx-visibility: hidden");
                TextField hueManual = new TextField();
                GridPane.setConstraints(hueManual, 2, 3);
                grid.getChildren().add(hueManual);

                hueManual.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        Double new_val = Double.parseDouble(hueManual.getText());
                        if (new_val <= 100 && new_val >= 0) {
                            colorAdjust.setHue(new_val/100);
                            hueValue.setText(String.format("%.2f", new_val));
                            hueValue.setStyle("-fx-visibility: visible");
                            grid.getChildren().remove(hueManual);
                        } 
                    }
                });
            }
        });

        //Add Saturation Objects to Scene
        saturationCaption.setTextFill(Color.BLACK);
        GridPane.setConstraints(saturationCaption, 0, 4);
        grid.getChildren().add(saturationCaption);

        GridPane.setConstraints(saturation, 1, 4);
        grid.getChildren().add(saturation);
 
        saturationValue.setTextFill(Color.BLACK);
        GridPane.setConstraints(saturationValue, 2, 4);
        grid.getChildren().add(saturationValue);

        //Change Saturation Value to Slider Value
        saturation.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    colorAdjust.setSaturation(new_val.doubleValue()/100);
                    saturationValue.setText(String.format("%.2f", new_val));
            }
        });
        saturation.setValue(0);

        //Button to set Saturation Value to Specific Value
        Button saturationButton = new Button();
        GridPane.setConstraints(saturationButton, 2, 4);
        grid.getChildren().add(saturationButton);

        saturationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                saturationValue.setStyle("-fx-visibility: hidden");
                TextField saturationManual = new TextField();
                GridPane.setConstraints(saturationManual, 2, 4);
                grid.getChildren().add(saturationManual);

                saturationManual.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        Double new_val = Double.parseDouble(saturationManual.getText());
                        if (new_val <= 100 && new_val >= 0) {
                            colorAdjust.setSaturation(new_val/100);
                            saturationValue.setText(String.format("%.2f", new_val));
                            saturationValue.setStyle("-fx-visibility: visible");
                            grid.getChildren().remove(saturationManual);
                        } 
                    }
                });
            }
        });

        //Grid Location and Addition to Scene
        grid.setLayoutX(1300);
        grid.setLayoutY(150);
        root.getChildren().add(grid);

        //Declare Scene Dimensions
        Scene scene = new Scene(root, (int)wImage.getWidth(), (int)wImage.getHeight());
        scene.getStylesheets().add("/CSS/Unit4.css");


        //Set and display scene
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Unit 4 Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
   
}

