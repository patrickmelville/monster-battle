package fighters;

public class Elf extends Monster implements MagicUser {
    public Elf(String n, int h, int s, int i, int m){
        super(n,h,s,i,m);
        hitPoints -= 0;
        strength += 10;
        intelligence += 15;
        magic += 25;
    }

    //attacking ability
    public int poison(){
        System.out.println("I can cast a spell that makes the air poisonous");
        return (int)Math.floor(Math.random()*(((magic+intelligence)/2)/6)) + 1;
    }
}
