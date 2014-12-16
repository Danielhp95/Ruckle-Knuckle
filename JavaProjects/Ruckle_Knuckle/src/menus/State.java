package menus;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import ruckleKnuckle.StateController;
import acm.graphics.GObject;
import acm.graphics.GRect;

public abstract class State {
	//GRect should change to the super class that allows changing colours
	protected HashMap<String, GRect> buttons = new HashMap<>() ;
	protected StateController controller;
	
	public State(StateController controller) {
		this.controller = controller;
	}
	
	public abstract void actionPerformed(ActionEvent e);
	public abstract void mousePressed(MouseEvent e);
	public abstract void keyPressed(KeyEvent e);
	
	public void enterState() {
		for (GObject o : buttons.values()) {
			controller.add(o);
		}
	}
	public void exitState() {
		controller.removeAll();
	}


}
