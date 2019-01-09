import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Testing extends Application{
    public void start(Stage stage){
        Troll h1 = new Troll("Kronk", 25,25,25,25);
        Mage h2 = new Mage("Gandalf", 25,25,25,25);

        //Creating a group
        Group root = new Group();
        //Create scene with group
        Scene scene = new Scene(root, 800, 600);

        //Create and setup a title Text object
        Text title = new Text();
        title.setText("Welcome to Codémon!");
        title.setX(scene.getWidth()/3);
        title.setY(50);
        title.setFont(Font.font("Arial", 20));
        //Add title to the group
        root.getChildren().add(title);


        // create new text to print out being 1 info
        Text player1 = new Text();
        player1.setText(h1.toString());
        player1.setX(50);
        player1.setY(100);
        root.getChildren().add(player1);

        // create new text to print out being 2 info
        Text player2 = new Text();
        player2.setText(h2.toString());
        player2.setX(350);
        player2.setY(100);
        root.getChildren().add(player2);

        //Adding a title to the window
        stage.setTitle("Monster Battle");
        //Adding scene to the stage
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
