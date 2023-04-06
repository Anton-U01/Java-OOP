package football.entities.field;

import football.entities.player.Player;

import java.util.stream.Collectors;

public class NaturalGrass extends BaseField{
    public NaturalGrass(String name) {
        super(name, 250);
    }


    @Override
    public String getInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s (%s):",this.getName(),getClass().getSimpleName())).append(System.lineSeparator());
        builder.append("Player: ");
        if(getPlayers().isEmpty()){
            builder.append("none").append(System.lineSeparator());
        } else {
            String string = getPlayers().stream().map(Player::getName).collect(Collectors.joining(" "));
            builder.append(string).append(System.lineSeparator());
        }
        builder.append("Supplement: ").append(getSupplements().size()).append(System.lineSeparator());
        builder.append("Energy: ").append(sumEnergy()).append(System.lineSeparator());
        return builder.toString().trim();
    }
}
