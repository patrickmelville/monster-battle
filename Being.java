public class Being {
    String name;
    int hitPoints;
    int strength;
    int intelligence;
    int magic;

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
        stats += name + " - " + this.getClass();
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

