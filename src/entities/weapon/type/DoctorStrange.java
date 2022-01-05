package entities.weapon.type;

import entities.base.Upgradeable;
import entities.base.Weapon;
import exception.IllegalValueException;
import gui.GameController;

public class DoctorStrange extends Weapon implements Upgradeable {

	public DoctorStrange() {
		super("DoctorStrange", "drstrange.gif", 4, 30);
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
