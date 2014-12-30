package healthBars;

import java.awt.Color;
import java.awt.Graphics;

import ruckleKnuckle.StateController;
import utils.GUtils;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GRectangle;

@SuppressWarnings("serial")
public class HealthBar extends GObject {

	private double currentHealth;

	//Length is determined by the initializer max health
	private final double LENGTH;
	private final double WIDTH = 75;

	private final double XLocation = 0;
	private final double YLocation = 0;

	// Color of health bar after damage
	private Color damageColor = Color.RED;
	// Full health color
	private Color healthColor = Color.GREEN;

	private GRect redBar;
	private GRect greenBar;
	private StateController controller;

	// Determines which side of the screen the bar is on
	private HealthBarSide side;

	public HealthBar(double maxHealth, HealthBarSide side,
			StateController controller) {

		this.side = side;
		this.controller = controller;

		//Sets the length of the health bar
		this.currentHealth = maxHealth;
		this.LENGTH = currentHealth;

		//Sets bar either on leftHandSide or RightHandSide
		handleBarSide(side);
		controller.add(redBar);
		controller.add(greenBar);
	}

	/*Depending on the side given as input, it will place
	 * the bar at the correct side of the window, right at the edge
	 */
	private void handleBarSide(HealthBarSide side) {
		if (side == HealthBarSide.LEFT) {
			greenBar = GUtils.createFilledBar(XLocation, YLocation, LENGTH,
					WIDTH, healthColor);
			redBar = GUtils.createFilledBar(XLocation, YLocation, LENGTH,
					WIDTH, damageColor);
		} else {
            /*
             * width of screen minus length of the bars -1 fixes the right bar
             * in the correct position on the screen
             */
			greenBar = GUtils.createFilledBar(this.controller.getWindowWidth() - LENGTH - 1,
					YLocation, LENGTH, WIDTH, healthColor);
			redBar = GUtils.createFilledBar(this.controller.getWindowWidth() - LENGTH - 1, YLocation, LENGTH,
					WIDTH, damageColor);
		}
	}

	//TODO: FINDBUG that reduces health in opposite direction for right side bar
	public void reduceHealth(double damage) {
		currentHealth -= damage;
		if (side == HealthBarSide.RIGHT) {
			greenBar.setSize(currentHealth, WIDTH);	
			greenBar.setLocation(greenBar.getX() + damage, YLocation);
		} else {
			greenBar.setSize(currentHealth, WIDTH);	
		}
		
		
	}

	//This method is never called, needed to extend GObject
	@Override
	public GRectangle getBounds() {
		return null;
	}

	// Adds both bars to the gonctroller, greenBar needs to be added last
	@Override
	public void paint(Graphics arg0) {
		controller.add(redBar);
		controller.add(greenBar);
	}

	//Used to determine if a character is dead
	public double getCurrentHealth() {
		return currentHealth;
	}

}
