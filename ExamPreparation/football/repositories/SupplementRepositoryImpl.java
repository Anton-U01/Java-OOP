package football.repositories;

import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public class SupplementRepositoryImpl implements SupplementRepository{
    private Collection<Supplement> supplements;

    public SupplementRepositoryImpl() {
        this.supplements = new ArrayList<>();
    }

    @Override
    public void add(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public boolean remove(Supplement supplement) {
        if(supplements.contains(supplement)){
            supplements.remove(supplement);
            return true;
        }
        return false;
    }

    @Override
    public Supplement findByType(String type) {
        for (Supplement supplement : supplements) {
            if(supplement.getClass().getSimpleName().equals(type)){
                return supplement;
            }
        }
        return null;
    }
}
