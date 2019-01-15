package fighters;

public class Monster extends Being{

    public Monster(String n, int h, int s, int i, int m){
        super(n,h,s,i,m);
        hitPoints += 25;
        strength += 25;
        intelligence += 0;
        magic += 0;
    }

    public String communicate(String msg) {
        return name + " growls '" + msg + "'";
    }

    //attacking ability
    public void bite(){
        System.out.println("I can bite because I am a rabid beast!");
    }

    //defensive ability
    public void dodge(){ System.out.println("I can dodge attacks sometimes because I am a monster!"); }
}
