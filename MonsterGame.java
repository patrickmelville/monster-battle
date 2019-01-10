import java.util.ArrayList;

public class MonsterGame {
    public static void main(String[] args){

        Being b1 = new Being("Being 1", 25,25,25,25);
        Being h1 = new Human("Patrick", 25,25,25,25);
        Being m1 = new Monster("Snarf", 25,25,25,25);

        Knight h2 = new Knight("Arthur", 25,25,25,25);
        Troll m2 = new Troll("Kronk", 25,25,25,25);

        Mage h3 = new Mage("Gandalf", 50,0,25,25);
        Elf m3 = new Elf("Morgana", 25,25,25,25);

        System.out.println(h3);
        test(h3);
    }

    public static void test(Being obj){
        int statPoints;
        int testsPassed = 0;
        System.out.println("Hero Info: " + obj.getClass());

        if (obj.getClass().getTypeName().equals("Knight") || obj.getClass().getTypeName().equals("Mage")){
            System.out.println(obj.getClass().getSuperclass().getTypeName().equals("Human") + " : Required SuperClass == Human");
            testsPassed++;
        }else if(obj.getClass().getTypeName().equals("Troll") || obj.getClass().getTypeName().equals("Elf")){
            System.out.println(obj.getClass().getSuperclass().getTypeName().equals("Monster") + " : Required SuperClass == Monster");
            testsPassed++;
        }else{
            System.out.println("FALSE : Required SuperClass != Knight/Mage => Human  || Troll/Elf => Monster");
        }

        System.out.println(obj.getClass().getSuperclass().getSuperclass().getTypeName().equals("Being") + " : Required SuperClass == Being");
        testsPassed = obj.getClass().getSuperclass().getSuperclass().getTypeName().equals("Being") ? testsPassed+1 : testsPassed;

        System.out.println((obj.name!=null) + " : Required Being has name - " + obj.name);
        testsPassed = obj.name!=null ? testsPassed+1 : testsPassed;

        statPoints = obj.hitPoints + obj.strength + obj.intelligence + obj.magic;
        System.out.println("" + (statPoints <= 200) + " : Required Stat Points <= 200");
        testsPassed = statPoints <= 200 ? testsPassed+1 : testsPassed;

        System.out.println((obj.hitPoints >= 5) + " : Required Hit Points >= 5 - " + obj.hitPoints);
        testsPassed = obj.hitPoints >= 5 ? testsPassed+1 : testsPassed;

        if (obj.getClass().getInterfaces().length > 0) {
            System.out.println((obj.getClass().getInterfaces().length > 0) + " : Required Hero class implements an interface -- " + obj.getClass().getInterfaces()[0]);
            testsPassed = obj.getClass().getInterfaces().length > 0 ? testsPassed+1 : testsPassed;

            if(obj.getClass().getInterfaces()[0].getName().equals("Fighter")){
                System.out.print(obj.getClass().getInterfaces()[0].getName().equals("Fighter"));
                System.out.println(" : Required Interface matches Class type. Knight/Troll => Fighter = " + obj.getClass().getInterfaces()[0].getName());
                testsPassed = obj.getClass().getInterfaces()[0].getName().equals("Fighter") ? testsPassed+1 : testsPassed;
            } else if(obj.getClass().getInterfaces()[0].getName().equals("MagicUser")){
                System.out.print(obj.getClass().getInterfaces()[0].getName().equals("MagicUser"));
                System.out.println(" : Required Interface matches Class type. Mage/Elf => MagicUser = " + obj.getClass().getInterfaces()[0].getName());
                testsPassed = obj.getClass().getInterfaces()[0].getName().equals("MagicUser") ? testsPassed+1 : testsPassed;
            }else{System.out.println("FALSE : Required Interface matches Class type. Mage/Elf => MagicUser");}

            if(obj.getClass().getInterfaces()[0].getName().equals("Fighter")){
                System.out.print(obj.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName().equals("slash"));
                testsPassed = obj.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName().equals("slash") ? testsPassed+1 : testsPassed;
            } else if(obj.getClass().getInterfaces()[0].getName().equals("MagicUser")){
                System.out.print(obj.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName().equals("cast"));
                testsPassed = obj.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName().equals("cast") ? testsPassed+1 : testsPassed;
            } else{System.out.println("FALSE");}
            System.out.println(" : Required Interface contains correct default method. Fighter has slash() / MagicUser has cast() = " + obj.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName());

        }
        else
            System.out.println((obj.getClass().getInterfaces().length > 0) + " : Required Hero class implements an interface -- CURRENTLY NO INTERFACES");
        System.out.println(testsPassed);

    }
}
