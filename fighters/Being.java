package fighters;

public class Being {
    public String name;
    public int hitPoints;
    public int strength;
    public int intelligence;
    public int magic;
    // String for image filename
    public String imageLocation;
    // String[] for messages??

    public Being(String n, int h, int s, int i, int m){
        name = n;
        hitPoints = h;
        strength = s;
        intelligence = i;
        magic = m;

    }
    public Being(String n, int h, int s, int i, int m, String loc){
        name = n;
        hitPoints = h;
        strength = s;
        intelligence = i;
        magic = m;
        imageLocation = loc;
    }

    @Override
    public String toString() {
        String stats = "\n";
        stats += name + " the " + this.getClass().getName().split("\\.")[1];
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

