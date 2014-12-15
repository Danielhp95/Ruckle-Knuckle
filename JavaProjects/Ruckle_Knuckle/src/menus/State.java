package menus;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Set;

import ruckleKnuckle.StateController;
import acm.graphics.GObject;

public abstract class State {
	protected HashMap<String, GObject> buttons = new HashMap<>() ;
	protected StateController controller;
	
	public State(StateController controller) {
		this.controller = controller;
	}
	
	public abstract void actionPerformed(ActionEvent e);
	public abstract void mousePressed(MouseEvent e);
	
	public void enterState() {
		for (GObject o : buttons.values()) {
			controller.add(o);
		}
	}
	public void exitState() {
		controller.removeAll();
	}


}
