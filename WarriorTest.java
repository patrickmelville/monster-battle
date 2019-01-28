import fighters.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class WarriorTest {

    public static void main(String[] args){
        Troll p1 = new Troll("Moblin", 50, 50, 20, 0);
        Mage p2 = new Mage("Gandalf", 45, 10, 20, 25);
        Knight p3 = new Knight("Link", 25, 25, 25, 25);
        Elf p4 = new Elf("Legolas", 0, 25, 25, 25);
        WarriorTest test1 = new WarriorTest();

        test1.testWarrior(p1);
        System.out.println(p1);
    }

    public boolean testWarrior(Being fighter){
        boolean testsPassed = false;

        // identify fighter type
        switch (fighter.getClass().getName()){
            case "fighters.Knight":
                System.out.println("--------------------------------------------------------");
                System.out.println("----------------- Start Knight Testing -----------------");
                System.out.println("--------------------------------------------------------");
                // test correct parent class = human
                boolean kTest1 = fighter.getClass().getSuperclass().getName().equals("fighters.Human");
                System.out.println(kTest1 + " --> correct parent class = human");
                // test correct grandparent class = being
                boolean kTest2 = fighter.getClass().getSuperclass().getSuperclass().getName().equals("fighters.Being");
                System.out.println(kTest2 + " --> correct grandparent class = being");
                // test has a name = string !=null
                boolean kTest3 = fighter.name != null;
                System.out.println(kTest3 + " --> has a name of type String that is != null");
                // test stat points equal 200
                boolean kTest4 = (fighter.hitPoints + fighter.strength + fighter.intelligence + fighter.magic) == 200;
                System.out.println(kTest4 + " --> stat points equal 200");
                // test type specific stat minimums (hp,str,intel, X)
                boolean kTest5 = fighter.hitPoints >=20 && fighter.strength >= 15 && fighter.intelligence >= 65;
                System.out.println(kTest5 + " --> hp>=20 / str>=15 / intel>=65");
                // test has methods (3 + communicate)
                Method[] kMethods = fighter.getClass().getSuperclass().getDeclaredMethods();
                String list[] = {kMethods[0].getName(),kMethods[1].getName(),kMethods[2].getName()};
                boolean kTest6 = Arrays.stream(list).anyMatch("communicate" ::equals);
                System.out.println(kTest6 + " --> has communicate() method");
                boolean kTest7 = Arrays.stream(list).anyMatch("punch" ::equals);
                System.out.println(kTest7 + " --> has punch() method");
                boolean kTest8 = Arrays.stream(list).anyMatch("bandage" ::equals);
                System.out.println(kTest8 + " --> has bandage() method");
                boolean kTest9 = fighter.getClass().getDeclaredMethods()[0].getName().equals("block");
                System.out.println(kTest9 + " --> has block() method");
                // test has interface "Fighter"
                boolean kTest10 = fighter.getClass().getInterfaces()[0].getName().equals("fighters.Fighter");
                System.out.println(kTest10 + " --> has Fighter Interface");
                // has interface default method = "slash"
                boolean kTest11 = fighter.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName().equals("slash");
                System.out.println(kTest11 + " --> has slash() default method from Fighter");
                
                // has the fighter passed all the tests?
                testsPassed = kTest1 && kTest2 && kTest3 && kTest4 && kTest5 && kTest6 && kTest7 && kTest8 && kTest9 && kTest10 && kTest11;
                break;
            case "fighters.Mage":
                System.out.println("--------------------------------------------------------");
                System.out.println("------------------ Start Mage Testing ------------------");
                System.out.println("--------------------------------------------------------");
                // test correct parent class = human
                boolean mTest1 = fighter.getClass().getSuperclass().getName().equals("fighters.Human");
                System.out.println(mTest1 + " --> correct parent class = human");
                // test correct grandparent class = being
                boolean mTest2 = fighter.getClass().getSuperclass().getSuperclass().getName().equals("fighters.Being");
                System.out.println(mTest2 + " --> correct grandparent class = being");
                // test has a name = string !=null
                boolean mTest3 = fighter.name != null;
                System.out.println(mTest3 + " --> has a name of type String that is != null");
                // test stat points equal 200
                boolean mTest4 = (fighter.hitPoints + fighter.strength + fighter.intelligence + fighter.magic) == 200;
                System.out.println(mTest4 + " --> stat points equal 200");
                // test type specific stat minimums
                boolean mTest5 = fighter.hitPoints > 0 && fighter.magic >= 25 && fighter.intelligence >= 75;
                System.out.println(mTest5 + " --> hp>=1 / int>=95 / mag>=35");
                // test has methods (3 + communicate)
                Method[] mMethods = fighter.getClass().getSuperclass().getDeclaredMethods();
                String mlist[] = {mMethods[0].getName(),mMethods[1].getName(),mMethods[2].getName()};
                boolean mTest6 = Arrays.stream(mlist).anyMatch("communicate" ::equals);
                System.out.println(mTest6 + " --> has communicate() method");
                boolean mTest7 = Arrays.stream(mlist).anyMatch("punch" ::equals);
                System.out.println(mTest7 + " --> has punch() method");
                boolean mTest8 = Arrays.stream(mlist).anyMatch("bandage" ::equals);
                System.out.println(mTest8 + " --> has bandage() method");
                boolean mTest9 = fighter.getClass().getDeclaredMethods()[0].getName().equals("weaken");
                System.out.println(mTest9 + " --> has weaken() method");
                // test has interface "Fighter"
                boolean mTest10 = fighter.getClass().getInterfaces()[0].getName().equals("fighters.MagicUser");
                System.out.println(mTest10 + " --> has MagicUser Interface");
                // has interface default method = "slash"
                boolean mTest11 = fighter.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName().equals("cast");
                System.out.println(mTest11 + " --> has cast() default method from MagicUser");

                // has the fighter passed all the tests?
                testsPassed = mTest1 && mTest2 && mTest3 && mTest4 && mTest5 && mTest6 && mTest7 && mTest8 && mTest9 && mTest10 && mTest11;
                break;
            case "fighters.Troll":
                System.out.println("--------------------------------------------------------");
                System.out.println("------------------ Start Troll Testing -----------------");
                System.out.println("--------------------------------------------------------");
                // test correct parent class = monster
                boolean tTest1 = fighter.getClass().getSuperclass().getName().equals("fighters.Monster");
                System.out.println(tTest1 + " --> correct parent class = Monster");
                // test correct grandparent class = being
                boolean tTest2 = fighter.getClass().getSuperclass().getSuperclass().getName().equals("fighters.Being");
                System.out.println(tTest2 + " --> correct grandparent class = being");
                // test has a name = string !=null
                boolean tTest3 = fighter.name != null;
                System.out.println(tTest3 + " --> has a name of type String that is != null");
                // test stat points equal 200
                boolean tTest4 = (fighter.hitPoints + fighter.strength + fighter.intelligence + fighter.magic) == 200;
                System.out.println(tTest4 + " --> stat points equal 200");
                // test type specific stat minimums 
                boolean tTest5 = fighter.hitPoints >=50 && fighter.strength >= 50;
                System.out.println(tTest5 + " --> hp>=50 / str>=50");
                // test has methods (3 + communicate)
                Method[] tMethods = fighter.getClass().getSuperclass().getDeclaredMethods();
                String tList[] = {tMethods[0].getName(),tMethods[1].getName(),tMethods[2].getName()};
                boolean tTest6 = Arrays.stream(tList).anyMatch("communicate" ::equals);
                System.out.println(tTest6 + " --> has communicate() method");
                boolean tTest7 = Arrays.stream(tList).anyMatch("bite" ::equals);
                System.out.println(tTest7 + " --> has bite() method");
                boolean tTest8 = Arrays.stream(tList).anyMatch("dodge" ::equals);
                System.out.println(tTest8 + " --> has dodge() method");
                boolean tTest9 = fighter.getClass().getDeclaredMethods()[0].getName().equals("criticalHit");
                System.out.println(tTest9 + " --> has criticalHit() method");
                // test has interface "Fighter"
                boolean tTest10 = fighter.getClass().getInterfaces()[0].getName().equals("fighters.Fighter");
                System.out.println(tTest10 + " --> has Fighter Interface");
                // has interface default method = "slash"
                boolean tTest11 = fighter.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName().equals("slash");
                System.out.println(tTest11 + " --> has slash() default method from Fighter");

                // has the fighter passed all the tests?
                testsPassed = tTest1 && tTest2 && tTest3 && tTest4 && tTest5 && tTest6 && tTest7 && tTest8 && tTest9 && tTest10 && tTest11;
                break;
            case "fighters.Elf":
                System.out.println("--------------------------------------------------------");
                System.out.println("------------------- Start Elf Testing ------------------");
                System.out.println("--------------------------------------------------------");
                // test correct parent class = monster
                boolean eTest1 = fighter.getClass().getSuperclass().getName().equals("fighters.Monster");
                System.out.println(eTest1 + " --> correct parent class = Monster");
                // test correct grandparent class = being
                boolean eTest2 = fighter.getClass().getSuperclass().getSuperclass().getName().equals("fighters.Being");
                System.out.println(eTest2 + " --> correct grandparent class = being");
                // test has a name = string !=null
                boolean eTest3 = fighter.name != null;
                System.out.println(eTest3 + " --> has a name of type String that is != null");
                // test stat points equal 200
                boolean eTest4 = (fighter.hitPoints + fighter.strength + fighter.intelligence + fighter.magic) == 200;
                System.out.println(eTest4 + " --> stat points equal 200");
                // test type specific stat minimums
                boolean eTest5 = fighter.hitPoints > 0 && fighter.strength >= 10 && fighter.magic >= 25 && fighter.intelligence >= 25;
                System.out.println(eTest5 + " --> hp>=1 / int>=40 / mag>=45");
                // test has methods (3 + communicate)
                Method[] eMethods = fighter.getClass().getSuperclass().getDeclaredMethods();
                String elist[] = {eMethods[0].getName(),eMethods[1].getName(),eMethods[2].getName()};
                boolean eTest6 = Arrays.stream(elist).anyMatch("communicate" ::equals);
                System.out.println(eTest6 + " --> has communicate() method");
                boolean eTest7 = Arrays.stream(elist).anyMatch("bite" ::equals);
                System.out.println(eTest7 + " --> has bite() method");
                boolean eTest8 = Arrays.stream(elist).anyMatch("dodge" ::equals);
                System.out.println(eTest8 + " --> has dodge() method");
                boolean eTest9 = fighter.getClass().getDeclaredMethods()[0].getName().equals("poison");
                System.out.println(eTest9 + " --> has poison() method");
                // test has interface "Fighter"
                boolean eTest10 = fighter.getClass().getInterfaces()[0].getName().equals("fighters.MagicUser");
                System.out.println(eTest10 + " --> has MagicUser Interface");
                // has interface default method = "slash"
                boolean eTest11 = fighter.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName().equals("cast");
                System.out.println(eTest11 + " --> has cast() default method from MagicUser");

                // has the fighter passed all the tests?
                testsPassed = eTest1 && eTest2 && eTest3 && eTest4 && eTest5 && eTest6 && eTest7 && eTest8 && eTest9 && eTest10 && eTest11;
                break;
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("     Your fighter has " + (testsPassed ? "" : "not ")  + "passed all the tests.");
        System.out.println("--------------------------------------------------------");
        return testsPassed;
    }
}
