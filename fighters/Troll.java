package fighters;

public class Troll extends Monster implements Fighter {
    public Troll(String n, int h, int s, int i, int m){
        super(n,h,s,i,m);
        hitPoints += 25;
        strength += 25;
        intelligence += 0;
        magic += 0;
    }

    //attacking ability
    public int criticalHit(){
        System.out.println("I can critically hit (extra damage) sometimes because I have sharp claws");
        double range = Math.floor(Math.random() * 5); // +-2
        double power = strength/8.5;
        return (int)Math.round(power-range);
    }

}
