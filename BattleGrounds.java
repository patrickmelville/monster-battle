import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BattleGrounds extends Application{
    public void start(Stage stage){
        // create objects for all players in the Battle Tournament
        Troll p1 = new Troll("Moblin", 25,25,25,25);
        Mage p2 = new Mage("Gandalf", 25,25,25,25);
        Knight p3 = new Knight("Link", 25,25,25,25);
        Elf p4 = new Elf("Legolas", 25,25,25,25);

        // add all player objects into an ArrayList
        ArrayList<Being> contenderList = new ArrayList<>();
        ArrayList<Being> playerList = new ArrayList<>();
        contenderList.add(p1);
        contenderList.add(p2);
        contenderList.add(p3);
        contenderList.add(p4);
        System.out.println(contenderList);

        // test all warriors. Copy them to final list and output names of those who failed
        WarriorTest tester = new WarriorTest();
        for(Being warrior : contenderList){
            if(tester.test(warrior)){
                playerList.add(warrior);
                System.out.println(warrior.name + " has passed");
            }
        }

        System.out.println(playerList);

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
        player1.setText(playerList.get(0).toString());
        player1.setX(50);
        player1.setY(100);
        root.getChildren().add(player1);

        // create new text to print out being 2 info
        Text player2 = new Text();
        player2.setText(playerList.get(1).toString());
        player2.setX(350);
        player2.setY(100);
        root.getChildren().add(player2);

        scene.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("SPACE")) {
                System.out.println("Move a step forward in the battle");
            }

        });

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
