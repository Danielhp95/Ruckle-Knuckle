package menus;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GRect;
import ruckleKnuckle.StateController;
import ruckleKnuckle.StateID;

public class Controls extends State {

	public Controls(StateController controller) {
		super(controller);
		buttons.put("back", new GRect(300, 600, 200, 70));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for (String s : buttons.keySet()) {
			GObject button = buttons.get(s);
			if (button.contains(e.getX(), e.getY())) {
				switch (s) {
				case "back":
					controller.goTo(StateID.MAIN_MENU);

				}
			}
		}
		
	}

}
