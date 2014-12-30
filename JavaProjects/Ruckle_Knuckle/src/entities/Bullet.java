package entities;

import java.awt.Graphics;

import ruckleKnuckle.StateController;
import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRectangle;

@SuppressWarnings("serial")
public class Bullet extends GObject implements Movable {

	private final double SPEED_REDUCTION_EXPONENT = -4.65;
	private final double ACCELERATION_REDUCTION_EXPONENT = -13;

	private GImage image;

	private double xSpeed;
	private double ySpeed;

	private double xAcceleration;
	private double yAcceleration;
	private StateController controller;

	public Bullet(GImage image, double xSpeed, double ySpeed,
			double xAcceleration, double yAcceleration,
			StateController controller) {
		this.image = image;
		this.xSpeed = xSpeed * Math.pow(10, SPEED_REDUCTION_EXPONENT);
		this.xAcceleration = xAcceleration
				* Math.pow(10, ACCELERATION_REDUCTION_EXPONENT);
		this.ySpeed = ySpeed;
		this.yAcceleration = yAcceleration;

		this.controller = controller;
		controller.add(image);
	}

	@Override
	public void move() {
		image.setLocation(image.getX() + xSpeed, image.getY() + ySpeed);

		// Speed is decreased over time
		xSpeed -= xAcceleration;
		ySpeed -= yAcceleration;
	}

	@Override
	public GRectangle getBounds() {
		return image.getBounds();
	}

	@Override
	public void paint(Graphics arg0) {
		controller.add(image);
	}

}
