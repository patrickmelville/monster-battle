import fighters.*;

public class WarriorTest {
    public boolean test(Being obj){
        int statPoints;
        int testsPassed = 0;
        System.out.println("Hero Info: " + obj.getClass());

        if (obj.getClass().getTypeName().equals("fighters.Knight") || obj.getClass().getTypeName().equals("fighters.Mage")){
            System.out.println(obj.getClass().getSuperclass().getTypeName().equals("fighters.Human") + " : Required SuperClass == fighters.Human");
            testsPassed++;
        }else if(obj.getClass().getTypeName().equals("fighters.Troll") || obj.getClass().getTypeName().equals("fighters.Elf")){
            System.out.println(obj.getClass().getSuperclass().getTypeName().equals("fighters.Monster") + " : Required SuperClass == fighters.Monster");
            testsPassed++;
        }else{
            System.out.println("FALSE : Required SuperClass != fighters.Knight/fighters.Mage => fighters.Human  || fighters.Troll/fighters.Elf => fighters.Monster");
        }

        System.out.println(obj.getClass().getSuperclass().getSuperclass().getTypeName().equals("fighters.Being") + " : Required SuperClass == fighters.Being");
        testsPassed = obj.getClass().getSuperclass().getSuperclass().getTypeName().equals("fighters.Being") ? testsPassed+1 : testsPassed;

        System.out.println((obj.name!=null) + " : Required fighters.Being has name - " + obj.name);
        testsPassed = obj.name!=null ? testsPassed+1 : testsPassed;

        statPoints = obj.hitPoints + obj.strength + obj.intelligence + obj.magic;
        System.out.println("" + (statPoints <= 200) + " : Required Stat Points <= 200");
        testsPassed = statPoints <= 200 ? testsPassed+1 : testsPassed;

        System.out.println((obj.hitPoints >= 5) + " : Required Hit Points >= 5 - " + obj.hitPoints);
        testsPassed = obj.hitPoints >= 5 ? testsPassed+1 : testsPassed;

        if (obj.getClass().getInterfaces().length > 0) {
            System.out.println((obj.getClass().getInterfaces().length > 0) + " : Required Hero class implements an interface -- " + obj.getClass().getInterfaces()[0]);
            testsPassed = obj.getClass().getInterfaces().length > 0 ? testsPassed+1 : testsPassed;

            if(obj.getClass().getInterfaces()[0].getName().equals("fighters.Fighter")){
                System.out.print(obj.getClass().getInterfaces()[0].getName().equals("fighters.Fighter"));
                System.out.println(" : Required Interface matches Class type. fighters.Knight/fighters.Troll => fighters.Fighter = " + obj.getClass().getInterfaces()[0].getName());
                testsPassed = obj.getClass().getInterfaces()[0].getName().equals("fighters.Fighter") ? testsPassed+1 : testsPassed;
            } else if(obj.getClass().getInterfaces()[0].getName().equals("fighters.MagicUser")){
                System.out.print(obj.getClass().getInterfaces()[0].getName().equals("fighters.MagicUser"));
                System.out.println(" : Required Interface matches Class type. fighters.Mage/fighters.Elf => fighters.MagicUser = " + obj.getClass().getInterfaces()[0].getName());
                testsPassed = obj.getClass().getInterfaces()[0].getName().equals("fighters.MagicUser") ? testsPassed+1 : testsPassed;
            }else{System.out.println("FALSE : Required Interface matches Class type. fighters.Mage/fighters.Elf => fighters.MagicUser");}

            if(obj.getClass().getInterfaces()[0].getName().equals("fighters.Fighter")){
                System.out.print(obj.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName().equals("slash"));
                testsPassed = obj.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName().equals("slash") ? testsPassed+1 : testsPassed;
            } else if(obj.getClass().getInterfaces()[0].getName().equals("fighters.MagicUser")){
                System.out.print(obj.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName().equals("cast"));
                testsPassed = obj.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName().equals("cast") ? testsPassed+1 : testsPassed;
            } else{System.out.println("FALSE");}
            System.out.println(" : Required Interface contains correct default method. fighters.Fighter has slash() / fighters.MagicUser has cast() = " + obj.getClass().getInterfaces()[0].getDeclaredMethods()[0].getName());

        }
        else
            System.out.println((obj.getClass().getInterfaces().length > 0) + " : Required Hero class implements an interface -- CURRENTLY NO INTERFACES");
        System.out.println(testsPassed);

        return testsPassed == 8;
    }
}
