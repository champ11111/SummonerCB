package entities.enemy.role;

import entities.base.Enemy;
import entities.base.Interactable;
import entities.base.Weapon;
import gui.GameController;

public class LeafGoblin extends Enemy implements Interactable {

	public LeafGoblin() {
		super("LeafGoblin", "leafgoblin.gif", 6, 3);
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
