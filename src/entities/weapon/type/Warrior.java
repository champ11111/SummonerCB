package entities.weapon.type;

import entities.base.Weapon;
import entities.base.Upgradeable;
import exception.IllegalValueException;
import gui.GameController;

public class Warrior extends Weapon implements Upgradeable {

	public Warrior() {
		super("Warrior", "warrior.gif", 1, 5);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean update() throws IllegalValueException {
		// TODO Auto-generated method stub
		if (GameController.getCurrentBalance() >= this.getUpgradeCost()) {
			return true;
		}
		return false;
	}

}
