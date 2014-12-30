package characters;

import healthBars.HealthBar;
import ruckleKnuckle.StateController;
import acm.graphics.GImage;

public class Dummy extends Character {

	public Dummy(HealthBar healthBar, double speed, double jumpHeight, StateController controller) {
		super(healthBar, controller);
		this.image = new GImage("../images/Dummy.png",200,200);
		image.scale(0.4);
		this.speed = speed;
		this.jumpHeight = jumpHeight;
		controller.add(image);
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

}
