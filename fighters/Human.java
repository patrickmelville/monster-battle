package fighters;

public class Human extends Being{

    public Human(String n, int h, int s, int i, int m){
        super(n,h,s,i,m);
        hitPoints += 0;
        strength += 0;
        intelligence += 50;
        magic += 0;
    }

    public String communicate(String msg) {
        return name + " says '" + msg + "'";
    }

    //attacking ability
    public void punch(){
        System.out.println("I can punch because I have arms!");
    }

    //defensive ability
    public void bandage(){ System.out.println("I can bandage myself because I am a human"); }
}
