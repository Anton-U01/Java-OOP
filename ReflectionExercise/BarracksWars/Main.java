package BarracksWars;

import BarracksWars.interfaces.Repository;
import BarracksWars.interfaces.Runnable;
import BarracksWars.interfaces.UnitFactory;
import BarracksWars.core.Engine;
import BarracksWars.core.factories.UnitFactoryImpl;
import BarracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();

    }
}
