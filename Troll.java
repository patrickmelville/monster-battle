public class Troll extends Monster implements Fighter {
    public Troll(String n, int h, int s, int i, int m){
        super(n,h,s,i,m);
        hitPoints += 25;
        strength += 25;
        intelligence += 0;
        magic += 0;
    }
}
