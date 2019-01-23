import fighters.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BattleGrounds extends Application {

    private static BattleInstance battle;

    public void start(Stage stage) throws FileNotFoundException {
        // create objects for all players in the Battle Tournament
        Troll p1 = new Troll("Moblin", 25, 25, 50, 0);
        Mage p2 = new Mage("Gandalf", 45, 10, 20, 25);
        Knight p3 = new Knight("Link", 50, 25, 25, 0);
        Elf p4 = new Elf("Legolas", 25, 25, 25, 25);

        // add all player objects into an ArrayList
        ArrayList<Being> contenderList = new ArrayList<>();
        ArrayList<Being> playerList = new ArrayList<>();
        contenderList.add(p1);
        contenderList.add(p2);
        contenderList.add(p3);
        contenderList.add(p4);

        // test all warriors. Copy them to final list and output names of those who failed
        WarriorTest tester = new WarriorTest();
        for (Being warrior : contenderList) {
            if (tester.testWarrior(warrior)) {
                playerList.add(warrior);
            }
        }

        for (Being warrior : playerList) {
            System.out.println(warrior.name + " has passed all test and is prepared for battle.");
        }

        //Creating a BattleInstance
//        BattleInstance battle = new BattleInstance(playerList.get(0), playerList.get(1));
        battle = new BattleInstance(playerList.get(0), playerList.get(1));
        //Creating a group
        Group root = new Group();
        //Create scene with group
        Scene scene = new Scene(root, 800, 600);

        //Create and setup a title Text object
        Text title = new Text();
        title.setText("Welcome to Codémon!");
        title.setX(scene.getWidth() / 3);
        title.setY(50);
        title.setFont(Font.font("Arial", 20));
        //Add title to the group
        root.getChildren().add(title);


        // create new text to print out being 1 info
        Text player1 = new Text();
        player1.setText(playerList.get(0).toString());
        player1.setX(50);
        player1.setY(300);
        root.getChildren().add(player1);

        // create new text to print out being 2 info
        Text player2 = new Text();
        player2.setText(playerList.get(1).toString());
        player2.setX(450);
        player2.setY(300);
        root.getChildren().add(player2);

        // create new Text for last battle event
        Text lastEvent = new Text();
        lastEvent.setText("The Battle is about to begin...");
        lastEvent.setX(250);
        lastEvent.setY(225);
        root.getChildren().add(lastEvent);

        // create new Image object for p1
        Image p1Image = new Image(new FileInputStream("src/knightPic.gif"));
        ImageView p1ImageView = new ImageView(p1Image);
        p1ImageView.setX(50);
        p1ImageView.setY(100);
        p1ImageView.setFitHeight(200);
        p1ImageView.setFitWidth(200);
        root.getChildren().add(p1ImageView);

        // create new Image object for p1
        Image p2Image = new Image(new FileInputStream("src/knightPic.gif"));
        ImageView p2ImageView = new ImageView(p2Image);
        p2ImageView.setX(450);
        p2ImageView.setY(100);
        p2ImageView.setFitHeight(200);
        p2ImageView.setFitWidth(200);
        root.getChildren().add(p2ImageView);

        scene.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("SPACE")) {
                // if there is still no winner
                if(battle.getWinner() == null) {
                    battle.advanceBattle();
                    lastEvent.setText(battle.getLastAction());
                    player1.setText(playerList.get(0).toString());
                    player2.setText(playerList.get(1).toString());
                } else{  // else start a new battle
                    System.out.println("START A NEW BATTLE");
                    // update the playerList: winner to end w/ orig stats & loser removed
                    battle.restoreOriginal(battle.getWinner());
                    playerList.add(battle.getWinner());
                    playerList.remove(0);
                    playerList.remove(0);

                    // new battle is created and visuals are updated
                    System.out.println(playerList);
                    battle = new BattleInstance(playerList.get(0), playerList.get(1));
                    lastEvent.setText("Two new warriors approach. A new battle is about to begin!");
                    player1.setText(playerList.get(0).toString());
                    player2.setText(playerList.get(1).toString());
                }
            }

        });

        //Adding a title to the window
        stage.setTitle("Monster Battle");
        //Adding scene to the stage
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
