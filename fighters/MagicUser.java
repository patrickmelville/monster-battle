package fighters;

public interface MagicUser {
    default int cast(int magic){
        System.out.println("I can cast a fireball spell because I am a magic user ");
        double range = Math.floor(Math.random() * 5)-2; // +-2
        double power = magic/7;
        return (int)Math.round(power+range);
    }
}
