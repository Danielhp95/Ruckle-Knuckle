package ruckleKnuckle;

import java.awt.event.MouseEvent;
import java.util.HashMap;

import menus.CharSelection;
import menus.MainMenu;
import menus.State;
import acm.program.GraphicsProgram;

public class StateController extends GraphicsProgram {

	private static final long serialVersionUID = 1L;

	private static final int WINDOW_WIDTH = 1280;
	private static final int WINDOW_LENGTH = 720;
	private static StateID currentState = StateID.MAIN_MENU;
	private HashMap<StateID, State> states;

	public void run() {
		resize(WINDOW_WIDTH, WINDOW_LENGTH);
		addMouseListeners();
		addKeyListeners();
		addActionListeners();

		createStateHashMap();
		goTo(currentState);
	}

	private void createStateHashMap() {
		states = new HashMap<>();
		states.put(StateID.MAIN_MENU, new MainMenu(this));
		states.put(StateID.CHAR_SELECTION, new CharSelection(this));
		states.put(StateID.BATTLE, new Battle(this));
		/*
		 * states.put(StateID.CONTROLS, new Controls(this));
		 * states.put(StateID.BATTLE, new Battle(this));
		 * states.put(StateID.GAME_OVER, new GameOver(this));
		 */
	}

	public void mousePressed(MouseEvent e) {
        states.get(currentState).mousePressed(e);
	}
	
	public void goTo(StateID newStateID) {
		states.get(currentState).exitState();
		currentState = newStateID;
		states.get(currentState).enterState();;
	}

}
