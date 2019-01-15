package fighters;

public interface Fighter {
    default void slash(){
        System.out.println("I can use a sword because I am a fighter");
    }
}
