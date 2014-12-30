package characters;

import healthBars.HealthBar;

import java.awt.Graphics;

import menus.Moves;
import ruckleKnuckle.StateController;
import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRectangle;
import entities.Movable;

public abstract class Character extends GObject implements Movable {

	private HealthBar healthBar;
	protected GImage image;

	protected double speed; // Run speed
	protected double jumpHeight; // How high char can jump
	protected boolean isAirbourne;

	protected Moves nextMove;

	private StateController controller;

	public Character(HealthBar healthBar, StateController controller) {
		this.healthBar = healthBar;
		this.isAirbourne = false; // Maybe should change this;
		this.nextMove = Moves.STANDBY;

		this.controller = controller;
	}

	public boolean isDead() {
		return healthBar.getCurrentHealth() <= 0;
	}

	public void nextMove(Moves nextMove) {
		this.nextMove = nextMove;
	}

	@Override
	public void move() {
		
		switch (nextMove) {
		case LEFT:
			image.setLocation(image.getX() - speed, image.getY());
			break;
		case RIGHT:
			image.setLocation(image.getX() + speed, image.getY());
			break;
		case JUMP:
			image.setLocation(image.getX(), image.getY() - jumpHeight);
			break;
		case STANDBY:
			break;
		}
		// after movement, does not repeat movement
		this.nextMove = Moves.STANDBY;
	}

	public abstract void jump();

	// Delegates to healthBar the reduction of health
	public void reduceHealth(double damage) {
		healthBar.reduceHealth(damage);
	}

	@Override
	public GRectangle getBounds() {
		return image.getBounds();
	}

	@Override
	public void paint(Graphics arg0) {
		controller.add(image);
		controller.add(healthBar);
	}

}
