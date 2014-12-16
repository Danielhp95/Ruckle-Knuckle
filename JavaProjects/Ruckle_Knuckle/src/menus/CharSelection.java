package menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import ruckleKnuckle.StateController;
import ruckleKnuckle.StateID;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class CharSelection extends State {

	private int player1Character;
	private int player2Character;
	private final int NUMBER_OF_CHARACTERS = 3;
	//Colors will change to character images
	private Color colors[];

	public CharSelection(StateController controller) {
		super(controller);

		Color firstCharColor = Color.RED;
		Color lastCharColor = Color.YELLOW;
		
		colors = new Color[NUMBER_OF_CHARACTERS];
		colors[0] = firstCharColor;
		colors[1] = Color.MAGENTA;
		colors[2] = lastCharColor;

		buttons.put("char1", createCharBox(160, 385, 160, 100, firstCharColor));
		buttons.put("char2", createCharBox(320, 385, 160, 100, Color.MAGENTA));
		buttons.put("char3", createCharBox(480, 385, 160, 100, lastCharColor));
		buttons.put("vs", new GRect(287.5, 70, 225, 225));
		buttons.put("player1Selection",
				createCharBox(30, 37.5, 225, 300, firstCharColor));
		buttons.put("player2Selection", createCharBox(542.5, 37.5, 225, 300, lastCharColor));
		buttons.put("battle", new GRect(300, 510, 200, 70));
		buttons.put("back", new GRect(300, 600, 200, 70));

		//Players start on opposite ends
		player1Character = 0;
		player2Character = NUMBER_OF_CHARACTERS - 1;

	}

	private GRect createCharBox(double i, double d, double k, double l,
			Color color) {
		GRect charBox = new GRect(i, d, k, l);
		charBox.setFilled(true);
		charBox.setFillColor(color);
		return charBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(player1Character + " " + player2Character);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			player1Character = (player1Character - 1 + NUMBER_OF_CHARACTERS)
					% NUMBER_OF_CHARACTERS;
			buttons.get("player1Selection").setFillColor(colors[player1Character]);
			break;
		case KeyEvent.VK_D:
			player1Character = (player1Character + 1) % NUMBER_OF_CHARACTERS;
			buttons.get("player1Selection").setFillColor(colors[player1Character]);
			break;
		case KeyEvent.VK_LEFT:
			player2Character = (player2Character - 1 + NUMBER_OF_CHARACTERS)
					% NUMBER_OF_CHARACTERS;
			buttons.get("player2Selection").setFillColor(colors[player2Character]);
			break;
		case KeyEvent.VK_RIGHT:
			player2Character = (player2Character + 1) % NUMBER_OF_CHARACTERS;
			buttons.get("player2Selection").setFillColor(colors[player2Character]);
			break;
		default:
			break;
		}
		System.out.println(player1Character + " " + player2Character);
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
