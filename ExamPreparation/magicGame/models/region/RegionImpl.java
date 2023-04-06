package magicGame.models.region;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region{
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> blackWidows = magicians.stream().filter(m -> m.getClass().getSimpleName().equals("BlackWidow")).collect(Collectors.toList());
        List<Magician> wizards = magicians.stream().filter(m -> m.getClass().getSimpleName().equals("Wizard")).collect(Collectors.toList());
        while (!blackWidows.isEmpty() && !wizards.isEmpty()){
            Magician blackWidow = blackWidows.get(0);
            Magician wizard = wizards.get(0);
            int widowBullets = wizard.getMagic().fire();
            if(widowBullets < 1){
                blackWidows.remove(blackWidow);
                continue;
            }
            blackWidow.takeDamage(widowBullets);
            if(blackWidow.isAlive()){
                int wizardsBullets = blackWidow.getMagic().fire();
                if(wizardsBullets < 10){
                    wizards.remove(wizard);
                    continue;
                }
                wizard.takeDamage(wizardsBullets);
                if(!wizard.isAlive()){
                    wizards.remove(0);
                }
            } else {
                blackWidows.remove(0);
            }
        }
        if(wizards.isEmpty()){
            return "Black widows win!";
        }
        return "Wizards win!";
    }
}
