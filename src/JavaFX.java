import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class JavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Text field for user input
        TextField input = new TextField();
        input.setPromptText("Enter a task");

        // Create a button that the user will click to submit their input
        Button addButton = new Button("Add Task");       
        
        // stores the list of tasks to be displayed
        ObservableList<String> tasks = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>(tasks);
        
        // Defines the buttons action upon click
        addButton.setOnAction(event -> {
            String task = input.getText(); // Get the text from the input field
            if(!task.isEmpty()) {
            	tasks.add(task);
            	input.clear();
            }
        });


        VBox root = new VBox(10);

        root.getChildren().addAll(input, addButton, listView);

        Scene scene = new Scene(root, 300, 250);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}