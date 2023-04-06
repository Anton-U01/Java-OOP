package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private SupplementRepository supplementRepository;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        switch (fieldType){
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }
        fields.add(field);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE,fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;
        switch (type){
            case "Powdered":
                supplement = new Powdered();
                break;
            case "Liquid":
                supplement = new Liquid();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        supplementRepository.add(supplement);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE,type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        if(supplementRepository.findByType(supplementType) == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND,supplementType));
        }
        Field field = null;
        for (Field field1 : fields) {
            if(field1.getName().equals(fieldName)){
                field = field1;
                break;
            }
        }
        if(field != null){
            field.addSupplement(supplementRepository.findByType(supplementType));
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD,supplementType,fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        switch (playerType){
            case "Men":
                player = new Men(playerName,nationality,strength);
                break;
            case "Women":
                player = new Women(playerName,nationality,strength);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
        
        Field field = null;
        for (Field field1 : fields) {
            if(field1.getName().equals(fieldName)){
                field = field1;
            }
        }
        switch (playerType){
            case "Men":
                if(field.getClass().getSimpleName().equals("NaturalGrass")){
                    field.addPlayer(player);
                    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD,playerType,fieldName);
                }
                break;
            case "Women":
                if(field.getClass().getSimpleName().equals("ArtificialTurf")){
                    field.addPlayer(player);
                    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD,playerType,fieldName);
                }
        }
        return ConstantMessages.FIELD_NOT_SUITABLE;
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = null;
        for (Field field1 : fields) {
            if (field1.getName().equals(fieldName)){
                field = field1;
                break;
            }
        }
        field.drag();
        return String.format(ConstantMessages.PLAYER_DRAG,field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = fields.stream().findFirst().filter(f -> f.getName().equals(fieldName)).get();
        int totalStrength = 0;
        for (Player player : field.getPlayers()) {
            totalStrength += player.getStrength();
        }
        return String.format(ConstantMessages.STRENGTH_FIELD,fieldName,totalStrength);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            sb.append(field.getInfo());
        }
        return sb.toString();
    }
}
