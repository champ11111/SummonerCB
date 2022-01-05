package gui;

import java.util.ArrayList;

import entities.base.Enemy;
import entities.base.Upgradeable;
import entities.base.Weapon;
import entities.enemy.role.Goblin;
import entities.enemy.role.GrimStonk;
import entities.enemy.role.LeafGoblin;
import entities.enemy.role.Orgmagi;
import entities.enemy.role.WaterGoblin;
import entities.weapon.type.Archer;
import entities.weapon.type.DoctorStrange;
import entities.weapon.type.FireWizard;
import entities.weapon.type.Titan;
import entities.weapon.type.Warrior;
import exception.IllegalValueException;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class GameController {

	private static int currentScore;
	private static int currentBalance;
	private static int upgradeCount;
	private static ArrayList<Weapon> weapons;
	private static Weapon player;
	public static Timeline time;
	private static Tooltip tooltip;

	public GameController() {
		weapons = new ArrayList<Weapon>();
		initWeapons();
		setCurrentBalance(0);
		setCurrentScore(0);
		setUpgradeCount(0);
		setPlayer(weapons.get(getUpgradeCount()));
	}

	public static Enemy randomEnemy(int pos) {
		switch (pos) {
		case 0:
			return new Goblin();
		case 1:
			return new GrimStonk();
		case 2:
			return new LeafGoblin();
		case 3:
			return new Orgmagi();
		case 4:
			return new WaterGoblin();
		}
		return null;

	}

	public void initWeapons() {
		Archer archer = new Archer();
		DoctorStrange doctorStrange = new DoctorStrange();
		Titan titan = new Titan();
		FireWizard fireWizard = new FireWizard();
		Warrior warrior = new Warrior();
		weapons.add(warrior);
		weapons.add(archer);
		weapons.add(fireWizard);
		weapons.add(doctorStrange);
		weapons.add(titan);
	}

	public static void initWeaponImage(ImageView weapon) {
		tooltip = new Tooltip();
		weapon.setImage(new Image(ClassLoader.getSystemResource(player.getUrl()).toString()));
		tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		tooltip.setText("Name: " + player.getWeaponName() + "\n" + "Attack_Damage: " + player.getAttackDamage());
		weapon.setOnMouseMoved((MouseEvent e) -> {
			if (weapon != null)
				tooltip.show(weapon, e.getScreenX(), e.getScreenY() + 10);
		});
		weapon.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}

	public static void setWeaponImage(ImageView image) throws IllegalValueException {
		if (isUpgrade(player)) {
			image.setImage(new Image(ClassLoader.getSystemResource(player.getUrl()).toString()));
			tooltip.setText("Name: " + player.getWeaponName() + "\n" + "Attack_Damage: " + player.getAttackDamage());
		}
	}

	public static boolean isUpgrade(Weapon player) throws IllegalValueException {
		if (player instanceof Upgradeable) {
			if (((Upgradeable) player).update()) {
				setUpgradeCount(getUpgradeCount() + 1);
				setPlayer(weapons.get(getUpgradeCount()));
				subtCurrentBalance(player);
				return true;
			}
		}
		return false;
	}

	public static void showWarning() {
		/*
		 * ====================FILL CODE============================ Show the Warning
		 * Dialogue according to the document.
		 */
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("You Lose");
		alert.setHeaderText(null);
		alert.setContentText("Try again next time");
		alert.showAndWait();
		/* ======================================================== */
	}

	public static void setScoreLabelText(Label score) {
		score.textProperty().setValue("Score: " + getCurrentScore());
	}

	public static void setBalanceLabelText(Label balance) {
		balance.textProperty().setValue("Balance: " + getCurrentBalance());
	}

	public static void setPriceLabelText(Label price) {
		price.textProperty().setValue("Price: " + getUpgradePrice(player));
	}


	public static void addCurrentScore(int currentScore) {
		GameController.currentScore += currentScore;
	}
	
	public static void addCurrentBalance(int currentBalance) {
		GameController.currentBalance += currentBalance;
	}

	public static void subtCurrentBalance(Weapon player) {
		GameController.currentBalance -= player.getUpgradeCost();
	}
	
	public static int getUpgradePrice(Weapon player) {
		return player.getUpgradeCost();
	}

	public static int getCurrentScore() {
		return currentScore;
	}
	
	public static void setCurrentScore(int currentScore) {
		GameController.currentScore = currentScore;
	}
	
	public static int getCurrentBalance() {
		return currentBalance;
	}

	public static void setCurrentBalance(int currentBalance) {
		GameController.currentBalance = currentBalance;
	}


	public static Weapon getPlayer() {
		return player;
	}

	public static void setPlayer(Weapon player) {
		GameController.player = player;
	}

	public static int getUpgradeCount() {
		return upgradeCount;
	}

	public static void setUpgradeCount(int upgradeCount) {
		GameController.upgradeCount = upgradeCount;
	}

	public static ArrayList<Weapon> getWeapons() {
		return weapons;
	}

}
