import fighters.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BattleInstance {
    private Being player1;
    private Being player2;
    private String whoseTurn;    // "p1" or "p2" or ""
    private boolean player1defending; // ready or defending
    private boolean player2defending; // ready or defending
    private String lastAction;
    private String lastValue;

    public BattleInstance(Being p1, Being p2) {
        player1 = p1;
        player2 = p2;
        whoseTurn = player1.name;
        player1defending = false;
        player2defending = false;
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

    public boolean isPlayer1defending() {
        return player1defending;
    }

    public boolean isPlayer2defending() {
        return player2defending;
    }

    public String getLastAction() {
        // if a player has died, set death message
        if (player1.hitPoints <= 0){
            return player2.name + " has defeated " + player1.name;
        } else if (player2.hitPoints <= 0){
            return player1.name + " has defeated " + player2.name;
        }
        // generate event String if both players are alive
        String event = "";
        String victim = getWhoseTurn().equals(player1.name) ? player1.name : player2.name;
        String attacker = victim.equals(player1.name) ? player2.name : player1.name;
        switch (lastAction) {

            case "punch":
            case "weaken":
            case "slash":
            case "poison":
                event = lastAction + "ed " + victim + " (" + lastValue + ")";
                break;
            case "bandage":
                event = lastAction + "d" + " (" + lastValue + ")";
                break;
            case "dodge":
                if (lastValue.equals("true"))
                    event = "dodged the next attack.";
                else
                    event = "failed to dodge the next attack.";
                break;
            case "block":
                if (lastValue.equals("true"))
                    event = "blocked the next attack.";
                else
                    event = "failed to block the next attack.";
                break;
            case "bite":
                event = "bit " + victim + " (" + lastValue + ")";
                ;
                break;
            case "criticalHit":
                event = "critically hit " + victim + " (" + lastValue + ")";
                ;
                break;
            case "cast":
                event = lastAction + " a fireball at " + victim + " (" + lastValue + ")";
                break;
        }

        return attacker + " " + event;
    }

    public void changeTurn() {
        if (getWhoseTurn().equals(player1.name)) {
            whoseTurn = player2.name;
        } else {
            whoseTurn = player1.name;
        }
    }

    public void updateStats(Being attacker, Being victim, String actionName, int value) {
        // update player stats
        if (actionName.equals("weaken")) {
            // remove value from both HP and STR of victim
            victim.hitPoints -= value;
            victim.strength -= value;
        } else if (actionName.equals("bandage")) {
            // add value to attacker's HP
            attacker.hitPoints += value;
        } else {
            // all other DMG attacks remove value from victim's HP
            // unless they are in defending state
            if (getWhoseTurn().equals(player1.name)) {
                if (!player2defending) {
                    victim.hitPoints -= value;
                }
            } else {
                if (!player1defending) {
                    victim.hitPoints -= value;
                }
            }


        }
    }

    public void setDefendingStance(boolean state) {
        if (getWhoseTurn().equals(player1.name)) {
            player1defending = state;
        } else {
            player2defending = state;
        }
    }

    public void advanceBattle() {
        // if both players still alive, continue battle...
        if (player1.hitPoints > 0 && player2.hitPoints > 0) {

            String[] completedAction; // example {"punch", "6"}
            String actionName;
            int statChange = 9001; // default is an impossible number
            Being attacker;
            Being victim;
            if (getWhoseTurn().equals(player1.name)) {
                attacker = getPlayer1();
                victim = getPlayer2();
            } else {
                attacker = getPlayer2();
                victim = getPlayer1();
            }
            // bring attacker out of defensive stance
            setDefendingStance(false);
            // now get a random action
            completedAction = getRandomAction(attacker).split("_");
            System.out.println(completedAction[0] + " _ " + completedAction[1]);
            // set variables to update stats with
            actionName = completedAction[0];
            if (!actionName.equals("dodge") && !actionName.equals("block")) {
                statChange = Integer.parseInt(completedAction[1]);
                // then update the stats for the victim
                updateStats(attacker, victim, actionName, statChange);
            } else {
                // else, update the attacker's status to "defending" instead because
                // they are blocking/dodging if the dodge/block was a success
                if (completedAction[1].equals("true")) {
                    System.out.println("SUCCESSFUL Block/Dodge... you are protected for next round");
                    setDefendingStance(true);
                } else {
                    // the block failed... still takes damage
                    System.out.println("Block/Dodge failed... GJ, you just wasted a turn");
                }
            }
            changeTurn();
        }
    }

    public String getRandomAction(Being warrior) {
        double r = Math.floor(Math.random() * 4);
        int random = (int) r;
        String methodName;
        String methodValue = "error";
        // if random number = index of "communicate" in list of methods use the "interface" method instead (always the last method in list)
        // otherwise invoke class methods based on random number
        if (warrior.getClass().getMethods()[random].getName().equals("communicate")) {
            methodName = warrior.getClass().getMethods()[warrior.getClass().getMethods().length - 1].getName();
        } else {
            methodName = warrior.getClass().getMethods()[random].getName();
        }
        // update lastAction info with method name
        lastAction = methodName; // "(" + methodValue + ") " +

        // invoke the random action
        try {
            // First get value of interface methods that have parameters
            // Then get value of all methods w/o parameters
            if (methodName.equals("slash")) {
                Method method = warrior.getClass().getMethod(methodName, int.class, int.class);
                methodValue = "" + method.invoke(warrior, warrior.strength, warrior.intelligence);
            } else if (methodName.equals("cast")) {
                Method method = warrior.getClass().getMethod(methodName, int.class);
                methodValue = "" + method.invoke(warrior, warrior.magic);
            } else {
                Method method = warrior.getClass().getMethod(methodName);
                methodValue = "" + method.invoke(warrior);
            }
            lastValue = methodValue;

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error:\n" + e.getMessage());
        }

        // return value from warrior action
        return methodName + "_" + methodValue;
    }
}
