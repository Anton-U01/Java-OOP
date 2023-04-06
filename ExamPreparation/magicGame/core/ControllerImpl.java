package magicGame.core;

import magicGame.common.ExceptionMessages;
import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.MagicRepositoryImpl;
import magicGame.repositories.MagicianRepositoryImpl;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        Magic magic;
        if(type.equals("RedMagic")){
            magic = new RedMagic(name,bulletsCount);
        } else if(type.equals("BlackMagic")){
            magic = new BlackMagic(name,bulletsCount);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
        }
        magics.addMagic(magic);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC,name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magician magician;
        Magic magic = null;
        for (Magic magicsDatum : magics.getData()) {
            if(magicsDatum.getName().equals(magicName)){
                magic = magicsDatum;
                break;
            }
        }
        if(magic == null){
            throw new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
        }
        if(type.equals("Wizard")){
            magician = new Wizard(username,health,protection,magic);
        } else if(type.equals("BlackWidow")){
            magician = new BlackWidow(username,health,protection,magic);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_TYPE);
        }
        magicians.addMagician(magician);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN,username);
    }

    @Override
    public String startGame() {
        List<Magician> magicianList = magicians.getData().stream().filter(Magician::isAlive).collect(Collectors.toList());;
        return region.start(magicianList);
    }

    @Override
    public String report() {
        magicians.getData().stream()
                .sorted(Comparator.comparing(Magician::getHealth).reversed()
                        .thenComparing(Magician::getUsername)
                        .thenComparing(m -> m.getClass().getSimpleName()))
                .collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        for (Magician magician : magicians.getData()) {
            builder.append(magician.toString());
        }
        return builder.toString().trim();
    }
}
