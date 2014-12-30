package menus;

import healthBars.HealthBar;
import healthBars.HealthBarSide;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import characters.Character;
import characters.Dummy;
import ruckleKnuckle.StateController;
import ruckleKnuckle.StateID;
import utils.GUtils;
import acm.graphics.GImage;
import entities.Bullet;
import entities.Platform;

public class Battle extends State {

	private characters.Character player1;
	private characters.Character player2;

	private Set<Bullet> movables;
	private Set<characters.Character> players;

	public Battle(StateController controller) {
		super(controller);
		// Allows for concurrent execution (moving and creating objects fast
		// among the set)
		movables = Collections
				.newSetFromMap(new ConcurrentHashMap<Bullet, Boolean>());
		players = Collections
				.newSetFromMap(new ConcurrentHashMap<characters.Character, Boolean>());

	}

	@Override
	public void enterState() {
		// Chosen characters and map
		player1 = GUtils.getCharacter(0,
				HealthBarSide.LEFT, controller);
		player2 = GUtils.getCharacter(0,
				HealthBarSide.RIGHT, controller);
		
		players.add(player1);
		//players.add(player2);
		
		int map = controller.getMap();

		controller.add(player1);
		//controller.add(player2);

		 startBattle();

	}

	private void startBattle() {
		Platform p = new Platform(new GImage("../images/vs.jpg", 700, 200),
				controller);
		controller.remove(p);
		while (!player1.isDead()) {
			for (Character m : players) {
				
				if (m.getBounds().intersects(p.getBounds())) {
					movables.remove(m);
					controller.remove(m);
				} else {
					
					m.move();
				}
			}
			for (Bullet m : movables) {

				if (m.getBounds().intersects(p.getBounds())) {
					movables.remove(m);
					controller.remove(m);
				} else {
					m.move();
				}
			}
		}
		
		controller.goTo(StateID.CHAR_SELECTION);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Bullet b = new Bullet(new GImage("../images/bullet.png", 0, 400), 5, 0,
				0.5, 0, controller);
		movables.add(b);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			player1.nextMove(Moves.JUMP);
			break;
		case KeyEvent.VK_A:
			player1.nextMove(Moves.LEFT);
			break;
		case KeyEvent.VK_S:
			break;
		case KeyEvent.VK_D:
			player1.nextMove(Moves.RIGHT);
			break;
		}
	}

}
