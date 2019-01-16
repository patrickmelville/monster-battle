import fighters.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BattleInstance {
    private Being player1;
    private Being player2;
    private String whoseTurn;    // "p1" or "p2" or ""
    private String player1State; // ready or defending
    private String player2State; // ready or defending
    private String[] lastAction = new String[2];

    public BattleInstance(Being p1, Being p2) {
        player1 = p1;
        player2 = p2;
        whoseTurn = "p1";
        player1State = "ready";
        player2State = "ready";
    }

    public Being getPlayer1() {
        return player1;
    }

    public Being getPlayer2() {
        return player2;
    }

    public String getWhoseTurn() {
        return whoseTurn;
    }

    public String getPlayer1State() {
        return player1State;
    }

    public String getPlayer2State() {
        return player2State;
    }

    public String getLastAction(){
        return lastAction[0] + " just did this: " + lastAction[1];
    }

    public void changeTurn() {
        if (getWhoseTurn().equals("p1")) {
            whoseTurn = "p2";
        } else {
            whoseTurn = "p1";
        }
    }

    public void updateStats(Being p) {
        // update changes
        // check for death

    }

    public void advanceBattle() {
        // check for player death...
        // (here)
        // if not... then next player does random action
        if (getWhoseTurn().equals("p1")) {
            doRandomAction(getPlayer1());
        } else {
            doRandomAction(getPlayer2());
        }
        changeTurn();
    }

    public void doRandomAction(Being warrior) {
        double r = Math.floor(Math.random() * 4);
        int random = (int) r;
        String methodName = "";
        // if random number = index of "communicate" in list of methods use the "interface" method instead (always the last method in list)
        // otherwise invoke class methods based on random number
        if (warrior.getClass().getMethods()[random].getName().equals("communicate")) {
            methodName = warrior.getClass().getMethods()[warrior.getClass().getMethods().length - 1].getName();
            System.out.println(methodName);
        } else {
            methodName = warrior.getClass().getMethods()[random].getName();
            System.out.println(methodName);
        }
        // update lastAction[] info with method name
        lastAction[0] = getWhoseTurn();
        lastAction[1] = methodName;

        // invoke the random action
        try {
            Method method = warrior.getClass().getMethod(methodName);
            method.invoke(warrior);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error:\n" + e.getMessage());
        }
    }
}
