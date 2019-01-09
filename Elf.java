public class Elf extends Monster implements MagicUser {
    public Elf(String n, int h, int s, int i, int m){
        super(n,h,s,i,m);
        hitPoints -= 25;
        strength -= 10;
        intelligence += 40;
        magic += 45;
    }
}