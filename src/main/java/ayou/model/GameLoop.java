package ayou.model;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ayou.view.Background;

public class GameLoop implements Runnable {

	static public int DECK_SIZE = 40;
	static public int START_HAND_SIZE = 5;
	static Player player1;
	static Player player2;
	final static Logger logger = LoggerFactory.getLogger(GameLoop.class);

	
	public void run() {
		player1 = new Player("Player1");
		player2 = new Player("Player2");

		startDraw(player1);
		startDraw(player2);

		while (!player1.isDefeated() && !player2.isDefeated()) {
			doTurn(player1, player2);
			doTurn(player2, player1);
		}

		if (player1.isDefeated())
			System.out.println("player 2 win !");
		else
			System.out.println("player 1 win !");

	}

//	private void doTurn(Player player, Player enemy) {
//		player.draw();
//
//		System.out.println(player + " hand :");
//		Displayer.display(player.getHand());
//		System.out.println();
//
//		if (player.isBoardEmpty())
//			player.invoke(player.getHand().get(Integer.parseInt(new Scanner(System.in).nextLine()) - 1));
//
//		System.out.println(player + " board :");
//		System.out.println(player.getBattler());
//		if (!enemy.isBoardEmpty()) {
//			System.out.println(enemy + " board :");
//			System.out.println(enemy.getBattler());
//		}
//		System.out.println();
//
//		if (!enemy.isBoardEmpty()) {
//			player.getBattler().attack(enemy.getBattler());
//			Displayer.attackCard(player.getBattler(), enemy.getBattler());
//			if (player.getBattler().getHitPoints() <= 0) {
//				player.takeDamages(1);
//				Displayer.die(player.getBattler());
//				player.cleanBoard();
//			}
//			if (enemy.getBattler().getHitPoints() <= 0) {
//				enemy.takeDamages(1);
//				Displayer.die(enemy.getBattler());
//				enemy.cleanBoard();
//			}
//		}
//		System.out.println(player + "    " + player.getShield());
//		System.out.println(enemy + "    " + enemy.getShield());
//	}
	private void doTurn(Player player, Player enemy){
		logger.debug(player1.toString() + " vs " + enemy.toString());
		player.draw();
//		System.out.println(player + " hand :");
//		Displayer.display(player.getHand());
//		System.out.println();
//
		if (player.isBoardEmpty());
			player.invoke(player.getHand().get(Integer.parseInt(new Scanner(System.in).nextLine()) - 1));

//		System.out.println(player + " board :");
//		System.out.println(player.getBattler());
//		if (!enemy.isBoardEmpty()) {
////			System.out.println(enemy + " board :");
////			System.out.println(enemy.getBattler());
//		}
//		System.out.println();
//
//		if (!enemy.isBoardEmpty()) {
//			player.getBattler().attack(enemy.getBattler());
////			Displayer.attackCard(player.getBattler(), enemy.getBattler());
//			if (player.getBattler().getHitPoints() <= 0) {
//				player.takeDamages(1);
////				Displayer.die(player.getBattler());
//				player.cleanBoard();
//			}
//			if (enemy.getBattler().getHitPoints() <= 0) {
//				enemy.takeDamages(1);
////				Displayer.die(enemy.getBattler());
//				enemy.cleanBoard();
//			}
//		}
//		System.out.println(player + "    " + player.getShield());
//		System.out.println(enemy + "    " + enemy.getShield());
		
	}
	

	private void startDraw(Player player) {
		for (int i = 0; i < START_HAND_SIZE; ++i)
			player.draw();
	}

}
