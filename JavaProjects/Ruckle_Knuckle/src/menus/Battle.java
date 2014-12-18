package menus;

import healthBars.HealthBar;
import healthBars.HealthBarSide;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GRect;
import ruckleKnuckle.StateController;
import utils.GUtils;

public class Battle extends State {

	private HealthBar healthBarPlayer1 = new HealthBar(300, HealthBarSide.LEFT, controller);
	private HealthBar healthBarPlayer2 = new HealthBar(500, HealthBarSide.RIGHT, controller);
	
	public Battle(StateController controller) {
		super(controller);
		
	}

	@Override
	public void enterState() {
		//Chosen characters and map
		int player1 = controller.getPlayer1character();
		int player2 = controller.getPlayer2character();
		int map     = controller.getMap();
		controller.add(healthBarPlayer1);
		controller.add(healthBarPlayer2);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		healthBarPlayer1.reduceHealth(10);
		healthBarPlayer2.reduceHealth(10);
	}

}
