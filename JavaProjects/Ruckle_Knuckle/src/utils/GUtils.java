package utils;

import healthBars.HealthBar;
import healthBars.HealthBarSide;

import java.awt.Color;

import ruckleKnuckle.StateController;
import acm.graphics.GRect;
import characters.Character;
import characters.Dummy;

public class GUtils {

	// Returns a bar at given location, length and with, with specified color
	public static GRect createFilledBar(double x, double y, double length,
			double width, Color color) {
		GRect bar = new GRect(x, y, length, width);
		bar.setFilled(true);
		bar.setFillColor(color);
		return bar;
	}

	public static Character getCharacter(int characterNumber,
			HealthBarSide side, StateController controller) {
		
		characters.Character character;
		HealthBar healthBar;
		switch (characterNumber) {
		case 0:
			healthBar = new HealthBar(300, side, controller);
			character = new Dummy(healthBar, 6, 3, controller);
			break;
		case 1:
			character = null;
			break;
		case 2:
			character = null;
			break;
		default:
			character = null;
			break;
		}
		return character;
	}
}
