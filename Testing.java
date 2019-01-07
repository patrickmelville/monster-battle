import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Testing extends Application{
    public void start(Stage stage){
        // create two new animals
        Animal c = new Cat("fluffy");
        Animal d = new Dog("spot");
        // create an ArrayList of type Animal
        ArrayList<Animal> aList = new ArrayList<>();
        // Add any animal that is a child of Animal class
        aList.add(c); // this is a Cat object
        aList.add(d); // this is a Dog object
        // print out my list of Animals
        System.out.println(aList);

        //Creating a group
        Group root = new Group();
        //Create scene with group
        Scene scene = new Scene(root, 800, 600);

        //Create and setup a title Text object
        Text title = new Text();
        title.setText("WECOME TO MONSTER BATTLE");
        title.setX(scene.getWidth()/3);
        title.setY(50);
        title.setFont(Font.font("Arial", 20));
        //Add title to the group
        root.getChildren().add(title);





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
