package entities;

import java.awt.Graphics;

import ruckleKnuckle.StateController;
import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRectangle;

@SuppressWarnings("serial")
public class Platform extends GObject{
	
	private GImage image;
	private StateController controller;
	
	public Platform(GImage image, StateController controller) {
		this.image  = image;
		this.controller = controller;
		
		controller.add(image);
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
