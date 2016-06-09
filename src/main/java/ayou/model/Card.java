package ayou.model;

import java.util.List;

import ayou.controller.Finger;

/**
 * @author aronowij
 *
 */
public class Card {

	public static final int IMG_SIZE_X = 30;
	public static final int IMG_SIZE_Y = 30;

	private int idCard;
	private String name;
	private String idImg;

	private int power;
	private int powerBuffs;
	private int maxHitPoints;
	private int lifeBuffs;
	private int hitPoints;

	private boolean canAttack;//can attack or never attack
	private boolean celerity;
	private int healAlly=100;
	private boolean healAllAllies;
	private int buffAlly;
	private boolean buffAllAllies;
	private int debuffEnemy;
	private boolean debuffAllEnemies;
	
	private boolean engagment=true;

	public Card(int idCard, String name, String idImg, int power, int maxHitPoints, boolean canAtk, boolean celerity,
			int healAlly, boolean healAllAllies, int buffAlly, boolean buffAllAllies, int debuffEnemy,
			boolean debuffAllEnemies) {
		this.idCard = idCard;
		this.name = name;
		this.idImg = "test";
		this.power = power;
		this.maxHitPoints = maxHitPoints;
		this.hitPoints = maxHitPoints;
		this.name = name;
		this.powerBuffs = 0;
		this.lifeBuffs = 0;
		this.canAttack = true;
		this.celerity = false;
		this.healAlly = 5;
		this.healAllAllies = true;
		this.buffAlly = 0;
		this.buffAllAllies = false;
		this.debuffEnemy = 0;
		this.debuffAllEnemies = false;
		this.powerBuffs = 0;
		this.lifeBuffs = 0;
		this.canAttack = canAtk;
		this.celerity = celerity;
		this.healAlly = healAlly;
		this.healAllAllies = healAllAllies;
		this.buffAlly = buffAlly;
		this.buffAllAllies = buffAllAllies;
		this.debuffEnemy = debuffEnemy;
		this.debuffAllEnemies = debuffAllEnemies;
		this.engagment=!celerity;
	}

	public Card(){
		
	}
	
	public int getCardID() {
		return idCard;
	}

	public void attack(Card targetCard) {
		if (canAttack) {
			targetCard.setHitPoints(getPower());
			setHitPoints(targetCard.getPower());
		}
	}
	
	public boolean canAttaque(){
		return canAttack;
	}
	

	public boolean isCelerity() {
		return celerity;
	}

	public void setCelerity(boolean celerity) {
		this.celerity = celerity;
	}

	public int getPower() {
		return power + powerBuffs;
	}

	public int getMaxHitPoints() {
		return maxHitPoints + lifeBuffs;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int damages) {
		hitPoints -= damages;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + " : " + getPower() + " - " + hitPoints;
	}

	public void getHealed(int heal) {
//		if (this.hitPoints + heal < this.maxHitPoints+this.lifeBuffs) {
//			hitPoints += heal;
//		} else {
//			hitPoints = maxHitPoints;
//		}
		hitPoints+=heal;
	}

	// @copyright
	public void getpowerBuffed(int buff) {
		powerBuffs += buff;
		if ((powerBuffs + power) < 0) {
			powerBuffs = -power;
		}
	}

	public void invocation(Player player) {
		System.out.println("invocation");
		Player enemy;
		if (player == GameLoop.getInstance().getPlayer1()) {
			enemy = GameLoop.getInstance().getPlayer2();
		} else {
			enemy = GameLoop.getInstance().getPlayer1();
		}
		if (healAlly > 0) {
			System.out.println("heal");
			if (healAllAllies) {
				for (Card card : player.getCardsOnBoard()) {
					card.getHealed(healAlly);
				}
			} else {
				Finger.selectCard(player.getCardsOnBoard()).getHealed(healAlly);
			}
		}
		if (debuffEnemy > 0) {
			if (debuffAllEnemies) {
				for (Card card : enemy.getCardsOnBoard()) {
					card.getpowerBuffed(-debuffEnemy);
				}
			} else {
				Finger.selectCard(GameLoop.getInstance().getPlayer2().getCardsOnBoard()).getpowerBuffed(-debuffEnemy);
			}
		}
		if (buffAlly > 0) {
			if (buffAllAllies) {
				for (Card card : player.getCardsOnBoard()) {
					card.getpowerBuffed(buffAlly);
				}
			} else {
				Finger.selectCard(player.getCardsOnBoard()).getpowerBuffed(buffAlly);
			}
		}

	}
	

	public int getLifeBuffs() {
		return lifeBuffs;
	}

	public void setLifeBuffs(int lifeBuffs) {
		this.lifeBuffs = lifeBuffs;
	}

	public int getIdCard() {
		return idCard;
	}

	public String getIdImg() {
		return idImg;
	}

	public boolean isCanAttack() {
		return canAttack;
	}

	public int getHealAlly() {
		return healAlly;
	}

	public boolean isHealAllAllies() {
		return healAllAllies;
	}

	public int getBuffAlly() {
		return buffAlly;
	}

	public boolean isBuffAllAllies() {
		return buffAllAllies;
	}

	public int getDebuffEnemy() {
		return debuffEnemy;
	}

	public boolean isDebuffAllEnemies() {
		return debuffAllEnemies;
	}

	public boolean isDead() {
		return hitPoints<=0;
	}

	public boolean isEngaged() {
		return engagment;
	}
	
	public void setEngagment(boolean engagment){
		this.engagment=engagment;
	}
	
	
}
