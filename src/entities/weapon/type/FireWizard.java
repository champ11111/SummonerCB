package entities.weapon.type;

import entities.base.Weapon;
import entities.base.Upgradeable;
import exception.IllegalValueException;
import gui.GameController;

public class FireWizard extends Weapon implements Upgradeable {

	public FireWizard() {
		super("FireWizard", "firewizard.gif", 3, 21);
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
