package fighters;

public interface Fighter {
    default int slash(int strength, int intelligence){
        System.out.println("I can use a sword because I am a fighter");
        double range = Math.floor(Math.random() * 5)-2; // +-2
        double power = ((strength*0.25) + (intelligence * 0.75))/7.5;
        return (int)Math.round(power+range);
    }
}
