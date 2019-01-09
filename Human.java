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

    public void punch(){
        System.out.println("I can punch because I have arms!");
    }
}