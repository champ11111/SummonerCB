package entities.base;

public class Weapon {
	private String weaponName;
	private String url;
	private int attackDamage;
	private int upgradeCost;

	public Weapon(String weaponName, String url, int attackDamage, int upgradeCost) {
		setWeaponName(weaponName);
		setAttackDamage(attackDamage);
		setUpgradeCost(upgradeCost);
		setUrl(url);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = "weapon/" + url;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public int getUpgradeCost() {
		return upgradeCost;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public void setUpgradeCost(int upgradeCost) {
		this.upgradeCost = upgradeCost;
	}

}
