package application;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;


public class Main extends Application {

   
   @Override
   public void start(Stage applicationStage) {
      Scene scene = null;         
      final GridPane gridPane = new GridPane();   
      
      scene = new Scene(gridPane); 
      Label menuLabel = new Label ("Menu: ");
      TextField dateTimeText = new TextField("");
      dateTimeText.setVisible(false);
      dateTimeText.setEditable(false);
      ComboBox<String> comboBox = new ComboBox<String>();
      comboBox.getItems().addAll(
    		  "Menu Item 1",
    		  "Menu Item 2",
    		  "Menu Item 3",
    		  "Menu Item 4"
    		  );
      
      comboBox.valueProperty().addListener(new ChangeListener<String>() {
          @Override public void changed(ObservableValue ov, String t, String t1) {
            if(t1 == "Menu Item 1") {
            	String date = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new Date());
            	dateTimeText.setText(date);
            	dateTimeText.setVisible(true);
            }
            if(t1 == "Menu Item 2") {
            	try {
            	  FileWriter myWriter = new FileWriter("log.txt");
        	      myWriter.write(dateTimeText.getText());
        	      myWriter.close();
        	      System.out.println("Successfully wrote to the file.");
        	    } catch (IOException e) {
        	      System.out.println("An error occurred.");
        	      e.printStackTrace();
        	    }
            }
            if(t1 == "Menu Item 3") {
            	gridPane.setStyle("-fx-background-color: #99ff99;");
            }
            if(t1 == "Menu Item 4") {
            	System.exit(0);
            }
          }    
      });
      gridPane.setPadding(new Insets(15, 15, 15, 15)); // Padding around  grid
      gridPane.setHgap(10);                            // Spacing between columns
      gridPane.setVgap(10);                            // Spacing between rows
      
      gridPane.add(menuLabel, 0, 0);
      gridPane.add(comboBox, 1, 0);
      gridPane.add(dateTimeText, 2, 0);
      

      applicationStage.setScene(scene);    // Set window's scene  
      applicationStage.setTitle("Menu"); // Set window's title
      applicationStage.show();             // Display window
   }
	
	public static void main(String[] args) {
		launch(args);
	}
}
