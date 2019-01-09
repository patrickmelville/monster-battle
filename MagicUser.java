public interface MagicUser {
    default void cast(){
        System.out.println("I can cast a fireball spell because I am a magic user ");
    }
}
