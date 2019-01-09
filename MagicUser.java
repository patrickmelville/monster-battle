public interface MagicUser {
    default void cast(){
        System.out.println("I can cast spells because I am a magic user. ");
    }
}
