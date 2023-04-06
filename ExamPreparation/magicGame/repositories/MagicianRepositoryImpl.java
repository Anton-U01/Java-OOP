package magicGame.repositories;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.Magician;
import magicGame.repositories.interfaces.MagicianRepository;

import java.util.ArrayList;
import java.util.Collection;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {
    private Collection<Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return data;
    }

    @Override
    public void addMagician(Magician magician) {
        if(magician == null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY);
        }
        data.add(magician);
    }

    @Override
    public boolean removeMagician(Magician magician) {
        if(data.contains(magician)){
            data.remove(magician);
            return true;
        }
        return false;
    }

    @Override
    public Magician findByUsername(String name) {
        for (Magician magician : data) {
            if(magician.getUsername().equals(name)){
                return magician;
            }
        }
        return null;
    }
}
