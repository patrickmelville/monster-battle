import fighters.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
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
        Troll p1 = new Troll("Moblin", 25, 60, 15, 0);
        Mage p2 = new Mage("Gandalf", 34, 0, 23, 43);
        Knight p3 = new Knight("Link", 30, 30, 40, 0, "src/linkCustom.png");
        Elf p4 = new Elf("Legolas", 25, 0, 35, 40);
        Troll p5 = new Troll("Moblin2", 25, 60, 15, 0, "src/testCustom.gif");
        Knight p6 = new Knight("Link2", 30, 30, 40, 0);

        //load custom images
        ArrayList<LocatedImage> customImages = new ArrayList<>();
        customImages.add(new LocatedImage("src/linkCustom.png"));
        customImages.add(new LocatedImage("src/testCustom.gif"));

        // load default images
        Image background = new Image(new FileInputStream("src/bg.jpg"));
        Image knightImage = new Image(new FileInputStream("src/knightPic.gif"));
        Image mageImage = new Image(new FileInputStream("src/magePic.jpg"));
        Image trollImage = new Image(new FileInputStream("src/trollPic.png"));
        Image elfImage = new Image(new FileInputStream("src/elfPic.jpg"));

        // add all player objects into an ArrayList
        ArrayList<Being> contenderList = new ArrayList<>();
        ArrayList<Being> playerList = new ArrayList<>();
        contenderList.add(p1);
        contenderList.add(p2);
        contenderList.add(p3);
        contenderList.add(p4);
        contenderList.add(p5);
        contenderList.add(p6);

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
        Scene scene = new Scene(root, 920, 675, Color.BLACK);

        // Create and add BG imageView
        ImageView bgView = new ImageView(background);
        bgView.setX(0);
        bgView.setY(0);
        bgView.setFitWidth(920);
        bgView.setFitHeight(675);
        root.getChildren().add(bgView);

        //Create and setup a title Text object
        Text title = new Text();
        title.setText("Welcome to Codémon!");
        title.setX(scene.getWidth() / 4);
        title.setY(50);
        title.setFont(Font.font("Impact", 40));
        //Add title to the group
        root.getChildren().add(title);


        // create new text to print out being 1 info
        Text player1 = new Text();
        player1.setText(playerList.get(0).toString());
        player1.setX(50);
        player1.setY(400);
        player1.setFont(Font.font("Consolas", 30));
        root.getChildren().add(player1);

        // create new text to print out being 2 info
        Text player2 = new Text();
        player2.setText(playerList.get(1).toString());
        player2.setX(550);
        player2.setY(400);
        player2.setFont(Font.font("Consolas", 30));
        root.getChildren().add(player2);

        // create new Text for last battle event
        Text lastEvent = new Text();
        lastEvent.setText("The Battle is about to begin...");
        lastEvent.setX(200);
        lastEvent.setY(655);
        lastEvent.setFont(Font.font("Verdana", 30));
        lastEvent.setFill(Color.RED);
        root.getChildren().add(lastEvent);

        // create new Image object for p1
        ImageView p1ImageView = new ImageView(trollImage);
        p1ImageView.setX(50);
        p1ImageView.setY(100);
        p1ImageView.setFitHeight(300);
        p1ImageView.setFitWidth(300);
        root.getChildren().add(p1ImageView);

        // create new Image object for p1
        ImageView p2ImageView = new ImageView(mageImage);
        p2ImageView.setX(550);
        p2ImageView.setY(100);
        p2ImageView.setFitHeight(300);
        p2ImageView.setFitWidth(300);
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

                    if (playerList.get(0).imageLocation == null) {
                        if (playerList.get(0).getClass().getName().equals("fighters.Knight")) {p1ImageView.setImage(knightImage);}
                        if (playerList.get(0).getClass().getName().equals("fighters.Mage")) {p1ImageView.setImage(mageImage);}
                        if (playerList.get(0).getClass().getName().equals("fighters.Troll")) {p1ImageView.setImage(trollImage);}
                        if (playerList.get(0).getClass().getName().equals("fighters.Elf")) {p1ImageView.setImage(elfImage);}
                    } else{
                        for( LocatedImage i : customImages){
                            if (i.getURL().equals(playerList.get(0).imageLocation)){
                                p1ImageView.setImage(i);
                            }
                        }
                    }
                    if (playerList.get(1).imageLocation == null){
                        if(playerList.get(1).getClass().getName().equals("fighters.Knight")){p2ImageView.setImage(knightImage);}
                        if(playerList.get(1).getClass().getName().equals("fighters.Mage")){p2ImageView.setImage(mageImage);}
                        if(playerList.get(1).getClass().getName().equals("fighters.Troll")){p2ImageView.setImage(trollImage);}
                        if(playerList.get(1).getClass().getName().equals("fighters.Elf")){p2ImageView.setImage(elfImage);}
                    }else{
                        for( LocatedImage i : customImages){
                            if (i.getURL().equals(playerList.get(1).imageLocation)){
                                p2ImageView.setImage(i);
                            }
                        }
                    }
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

    class LocatedImage extends Image {
        private final String url;

        public LocatedImage(String url) throws FileNotFoundException{
            super(new FileInputStream(url));
            this.url = url;
        }

        public String getURL() {
            return url;
        }
    }

}
