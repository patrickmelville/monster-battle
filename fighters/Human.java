package fighters;

public class Human extends Being {

    public Human(String n, int h, int s, int i, int m) {
        super(n, h, s, i, m);
        hitPoints += 0;
        strength += 0;
        intelligence += 50;
        magic += 0;
    }
    public Human(String n, int h, int s, int i, int m, String loc) {
        super(n, h, s, i, m, loc);
        hitPoints += 0;
        strength += 0;
        intelligence += 50;
        magic += 0;
    }

    public String communicate(String msg) {
        return name + " says '" + msg + "'";
    }

    //attacking ability
    public int punch() {
        System.out.println("I can punch because I have arms!");
        double range = Math.floor(Math.random() * 5)-2; // +-2
        double power = (strength+1) / 9;

        return (int) Math.round(Math.abs(power + range));
    }

    //defensive ability
    public int bandage() {
        System.out.println("I can bandage myself because I am a human");
        double range = Math.floor(Math.random() * 5)-2; // +-2
        double power = Math.floor(intelligence/12);
        System.out.println(range);
        return (int) Math.round(power - range);
    }
}
