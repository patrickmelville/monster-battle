package fighters;

public class Monster extends Being {

    public Monster(String n, int h, int s, int i, int m) {
        super(n, h, s, i, m);
        hitPoints += 25;
        strength += 25;
        intelligence += 0;
        magic += 0;
    }

    public String communicate(String msg) {
        return name + " growls '" + msg + "'";
    }

    //attacking ability
    public int bite() {
        System.out.println("I can bite because I am a rabid beast!");
        double range = Math.floor(Math.random() * 5)-2; // +-2
        double power = strength / 15;
        if (hitPoints <= 5) {
            power += 3;
        } // monsters bite harder when on the brink of death
        int result = (int) Math.round(power + range);
        result = result < 1 ? 1 : result;
        return result;
    }

    //defensive ability
    public boolean dodge() {
        System.out.println("I can dodge attacks sometimes because I am a monster!");
        double rand = Math.random();
        double mod = intelligence/200;
        // console.log(rand+mod)
        if (rand+mod > 0.866)
            return true;
        else
            return false;
    }
}
