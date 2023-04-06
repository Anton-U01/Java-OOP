package christmasRaces.repositories;

import christmasRaces.entities.races.Race;
import christmasRaces.repositories.interfaces.Repository;

import java.util.*;

public class RaceRepository implements Repository<Race> {
    private Map<String,Race> races;

    public RaceRepository() {
        this.races = new LinkedHashMap<>();
    }

    @Override
    public Race getByName(String name) {
        return races.get(name);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(races.values());
    }

    @Override
    public void add(Race race) {
        races.put(race.getName(),race);
    }

    @Override
    public boolean remove(Race race) {
        if(races.containsKey(race.getName())){
            races.remove(race.getName());
            return true;
        }
        return false;
    }
}
