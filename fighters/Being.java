package fighters;

public class Being {
    public String name;
    public int hitPoints;
    public int strength;
    public int intelligence;
    public int magic;
    // String for image filename???
    // String[] for messages??

    public Being(String n, int h, int s, int i, int m){
        name = n;
        hitPoints = h;
        strength = s;
        intelligence = i;
        magic = m;

    }

    @Override
    public String toString() {
        String stats = "\n";
        stats += name + " - " + this.getClass().getName();
        stats += "\nHP:  " + hitPoints;
        stats += "\nSTR: " + strength;
        stats += "\nINT: " + intelligence;
        stats += "\nMAG: " + magic;
        stats += "\nTotal: " + (hitPoints + strength + intelligence + magic);

        return stats;
    }

    public String communicate(String msg){
        return name + " sends message: " + msg;
    }
}

