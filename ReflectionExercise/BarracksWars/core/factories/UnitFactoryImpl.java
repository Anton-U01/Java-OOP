package BarracksWars.core.factories;

import BarracksWars.interfaces.Unit;
import BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		try {
			Class clazz = Class.forName("BarracksWars.models.units." + unitType);
			Constructor constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			return (Unit) constructor.newInstance();
		} catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException |IllegalAccessException e){
			e.printStackTrace();
		}
		return null;
	}
}
