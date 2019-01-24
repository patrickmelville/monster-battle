package fighters;

public class Mage extends Human implements MagicUser {
    public Mage(String n, int h, int s, int i, int m){
        super(n,h,s,i,m);
        hitPoints -= 0;
        strength -= 0;
        intelligence += 25;
        magic += 25;
    }
    public Mage(String n, int h, int s, int i, int m, String loc){
        super(n,h,s,i,m,loc);
        hitPoints -= 0;
        strength -= 0;
        intelligence += 25;
        magic += 25;
    }

    //attacking/defensive ability
    public int weaken(){
        System.out.println("I can cast a weakening spell on my enemies");
        double power = magic/8;
        double range = power/3 * Math.random();

        return (int)Math.floor(power-range);
    }

}
