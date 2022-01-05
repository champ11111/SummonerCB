package entities.enemy.role;

import entities.base.Enemy;
import entities.base.Interactable;
import entities.base.Weapon;
import gui.GameController;

public class Orgmagi extends Enemy implements Interactable {

	public Orgmagi() {
		super("Orgmagi", "orgi.gif", 15, 4);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void interact(Weapon e) {
		// TODO Auto-generated method stub
		this.setLifePoint(this.getLifePoint() - e.getAttackDamage());
		if (this.getLifePoint() <= 0) {
			this.setDead(true);
			// GameControll
			GameController.addCurrentBalance(this.getReward());
			GameController.addCurrentScore(this.getReward());
		}
	}

}
