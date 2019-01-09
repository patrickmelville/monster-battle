public class Mage extends Human implements MagicUser {
    public Mage(String n, int h, int s, int i, int m){
        super(n,h,s,i,m);
        hitPoints -= 20;
        strength -= 10;
        intelligence += 45;
        magic += 35;
    }
}
