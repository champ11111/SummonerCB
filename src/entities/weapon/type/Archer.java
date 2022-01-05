package entities.weapon.type;

import entities.base.Weapon;
import entities.base.Upgradeable;
import exception.IllegalValueException;
import gui.GameController;

public class Archer extends Weapon implements Upgradeable {

	public Archer() {
		super("Archer", "archer.gif", 2, 10);
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
