package menus;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GRect;
import ruckleKnuckle.StateController;
import ruckleKnuckle.StateID;

public class CharSelection extends State {

	public CharSelection(StateController controller) {
		super(controller);
		buttons.put("char1", new GRect(160, 385, 160, 100));
		buttons.put("char2", new GRect(320, 385, 160, 100));
		buttons.put("char3", new GRect(480, 385, 160, 100));
		buttons.put("vs", new GRect(287.5, 70, 225, 225));
		buttons.put("player1Selection", new GRect(30, 37.5, 225, 300));
		buttons.put("player2Selection", new GRect(542.5, 37.5, 225, 300));
		buttons.put("battle", new GRect(300, 510, 200, 70));
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
				case "CharSelection":
					controller.goTo(StateID.CHAR_SELECTION);
					break;
				case "Controls":
					controller.goTo(StateID.CONTROLS);
					break;
				case "battle":
					controller.goTo(StateID.BATTLE);
					break;
				case "back":
					controller.goTo(StateID.MAIN_MENU);

				}
			}
		}

	}

}
