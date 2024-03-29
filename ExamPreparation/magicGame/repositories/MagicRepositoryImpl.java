package magicGame.repositories;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;
import magicGame.repositories.interfaces.MagicRepository;

import java.util.ArrayList;
import java.util.Collection;

public class MagicRepositoryImpl implements MagicRepository<Magic> {
    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return data;
    }

    @Override
    public void addMagic(Magic magic) {
        if(magic == null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_REPOSITORY);
        }
        data.add(magic);
    }

    @Override
    public boolean removeMagic(Magic magic) {
        if(data.contains(magic)){
            data.remove(magic);
            return true;
        }
        return false;
    }

    @Override
    public Magic findByName(String name) {
        for (Magic magic : data) {
            if(magic.getName().equals(name)){
                return magic;
            }
        }
        return null;
    }
}
