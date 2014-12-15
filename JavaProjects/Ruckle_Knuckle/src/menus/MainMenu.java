package menus;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import ruckleKnuckle.StateController;
import ruckleKnuckle.StateID;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class MainMenu extends State{
	
	
	public MainMenu(StateController controller) {
		super(controller);
		buttons.put("CharSelection",new GRect(225, 250, 350, 100)); //charSelection+
		buttons.put("Controls",new GRect(250, 375, 300, 75)); //controls
		buttons.put("Credits",new GRect(250, 475, 300, 75)); //credits
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		for (String s: buttons.keySet()) {
			GObject button = buttons.get(s);
			if (button.contains(e.getX(), e.getY())) {
				switch (s) {
				case "CharSelection":
					controller.goTo(StateID.CHAR_SELECTION);
					break;
				case "Controls":
					controller.goTo(StateID.CONTROLS);
					break;
				case "Credits":
					controller.goTo(StateID.CREDITS);
					break;
					
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
