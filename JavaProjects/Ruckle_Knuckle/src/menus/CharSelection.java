package menus;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import ruckleKnuckle.StateController;
import ruckleKnuckle.StateID;
import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class CharSelection extends State {

	
	
	private ArrayList<GImage> characters;
	private ArrayList<GImage> maps;

	// Vs image
	GImage vsImage = new GImage("images/vs.jpg", 287.5, 70);
	GImage player1selection;
	GImage player2selection;
	GImage currentMap;
	
	private int player1Character;
	private int player2Character;
	private int mapNumber;

	public CharSelection(StateController controller) {
		super(controller);
		// Characters images
		characters = new ArrayList<>();
		maps       = new ArrayList<>();
		characters.add(new GImage("images/1.jpg", 160, 385));
		characters.add(new GImage("images/2.jpg", 320, 385));
		characters.add(new GImage("images/3.jpg", 480, 385));
		
		maps.add(new GImage("images/1.jpg"));
		maps.add(new GImage("images/2.jpg"));
		maps.add(new GImage("images/3.jpg", 700, 385));

		//Same images as 
		player1selection = new GImage("images/1.jpg", 30, 37.5);
		player2selection = new GImage("images/3.jpg", 542.5, 37.5);
		currentMap = new GImage(maps.get(0).getImage(), 700, 385);

		buttons.put("battle", new GRect(300, 510, 200, 70));
		buttons.put("back", new GRect(300, 600, 200, 70));

	}
	
	public int getPlayer1character() {
		return player1Character;
	}
	
	public int getPlayer2character() {
		return player2Character;
	}
	
	public int getMap() {
		return mapNumber;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * Loades buttons AND images
	 */
	@Override
	public void enterState() {
		super.enterState();
		
		//Resets view, no information is stored if menu is exited
		mapNumber = 0;
		//players start on opposite ends
		player1Character = 0;
		player2Character = characters.size() - 1;
		
		player1selection.setImage(characters.get(player1Character).getImage());
		player2selection.setImage(characters.get(player2Character).getImage());
		currentMap.setImage(maps.get(mapNumber).getImage());
		
		
		vsImage.scale(0.60);
		controller.add(vsImage);
		for (GImage i : characters) {
			controller.add(i);
		}
		controller.add(player1selection);
		controller.add(player2selection);
		controller.add(currentMap);
	}

	/*
	 * Change the character selected for both players
	 * Character selection wraps around the edges
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			player1Character = (player1Character - 1 + characters.size())
					% characters.size();
			break;
		case KeyEvent.VK_D:
			player1Character = (player1Character + 1) % characters.size();
			break;
		case KeyEvent.VK_LEFT:
			player2Character = (player2Character - 1 + characters.size())
					% characters.size();
			break;
		case KeyEvent.VK_RIGHT:
			player2Character = (player2Character + 1) % characters.size();
			break;
		case KeyEvent.VK_M:
			mapNumber = (mapNumber + 1) % maps.size();
		default:
			break;
		}
		// TODO: Border around currently selected characters
		/*
		 * Images are rendered with each keyPress. This cleans up the code a
		 * little and does not take up many computations.
		 */
		player1selection.setImage(characters.get(player1Character).getImage());
		player2selection.setImage(characters.get(player2Character).getImage());
		currentMap.setImage(maps.get(mapNumber).getImage());
		
		

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
					break;
				}
			}
		}

	}

}
