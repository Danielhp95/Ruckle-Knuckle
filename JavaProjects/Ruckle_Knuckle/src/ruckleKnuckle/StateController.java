package ruckleKnuckle;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import menus.Battle;
import menus.CharSelection;
import menus.Controls;
import menus.Credits;
import menus.MainMenu;
import menus.State;
import acm.program.GraphicsProgram;

public class StateController extends GraphicsProgram {

	private static final long serialVersionUID = 1L;

	private static final int WINDOW_WIDTH = 1280;
	private static final int WINDOW_LENGTH = 720;
	private static StateID currentState = StateID.BATTLE; // Starting state
	private HashMap<StateID, State> states; //Contains all states

	// Main Loop for the application
	public void run() {
		resize(WINDOW_WIDTH, WINDOW_LENGTH);
		createStateHashMap();
		addMouseListeners();
		addKeyListeners();
		addActionListeners();

		goTo(currentState);
	}

	// Populates hashMap with all the states
	private void createStateHashMap() {
		states = new HashMap<>();
		states.put(StateID.MAIN_MENU, new MainMenu(this));
		states.put(StateID.CHAR_SELECTION, new CharSelection(this));
		states.put(StateID.BATTLE, new Battle(this));
		states.put(StateID.CONTROLS, new Controls(this));
		states.put(StateID.CREDITS, new Credits(this));
		/*
		 * states.put(StateID.GAME_OVER, new GameOver(this));
		 */
	}

	/*
	 * This two functions delegate each action to the current state to handle
	 */
	public void mousePressed(MouseEvent e) {
		states.get(currentState).mousePressed(e);
	}

	public void keyPressed(KeyEvent e) {
		states.get(currentState).keyPressed(e);
	}

	/*
	 * Called by the different States exits curent state and calls initializer
	 * for the given following state.
	 */
	public void goTo(StateID newStateID) {
		states.get(currentState).exitState();
		currentState = newStateID;
		states.get(currentState).enterState();
	}

	// Information to transfer between character selection and battle
	public int getPlayer1character() {
		return ((CharSelection) states.get(StateID.CHAR_SELECTION))
				.getPlayer1character();
	}

	public int getPlayer2character() {
		return ((CharSelection) states.get(StateID.CHAR_SELECTION))
				.getPlayer2character();

	}

	public int getMap() {
		return ((CharSelection) states.get(StateID.CHAR_SELECTION)).getMap();
	}

	public double getWindowWidth(){
		return WINDOW_WIDTH;
	}

}
