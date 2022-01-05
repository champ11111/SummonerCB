package entities.base;

public class Enemy {
	private String enemyName;
	private String url;
	private int lifePoint;
	private int reward;
	private boolean isDead;

	public Enemy(String enemyName, String url, int lifePoint, int reward) {
		setEnemyName(enemyName);
		setLifePoint(lifePoint);
		setReward(reward);
		setDead(false);
		setUrl(url);
	}

	public int getLifePoint() {
		return lifePoint;
	}

	public int getReward() {
		return reward;
	}

	public boolean isDead() {
		if (lifePoint <= 0) {
			isDead = true;
		}
		return isDead;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}

	public void setReward(int reward) {
		if (reward < 1) {
			this.reward = 1;
			return;
		}
		this.reward = reward;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public String getEnemyName() {
		return enemyName;
	}

	public String getUrl() {
		return url;
	}

	public void setEnemyName(String enemyName) {
		this.enemyName = enemyName;
	}

	public void setUrl(String url) {
		this.url = "enemy/" + url;
	}

}
