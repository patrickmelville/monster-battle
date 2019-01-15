package fighters;

public class Knight extends Human implements Fighter{

    public Knight(String n, int h, int s, int i, int m){
        super(n,h,s,i,m);
        hitPoints += 20;
        strength += 15;
        intelligence += 15;
        magic += 0;
    }

    //defensive ability
    public void block(){ System.out.println("I can block attacks because I have a shield"); }
}