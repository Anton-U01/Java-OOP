package football.entities.player;

public class Women extends BasePlayer{
    public Women(String name, String nationality, int strength) {
        super(name, nationality, 60, strength);
    }

    @Override
    public void stimulation() {
        int currentStrength = getStrength();
        this.setStrength(currentStrength + 115);
    }
}
