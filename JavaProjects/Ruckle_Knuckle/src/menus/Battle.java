package menus;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import ruckleKnuckle.StateController;

public class Battle extends State {

	public Battle(StateController controller) {
		super(controller);
		
	}

	@Override
	public void enterState() {
		//Chosen characters and map
		int player1 = controller.getPlayer1character();
		int player2 = controller.getPlayer2character();
		int map     = controller.getMap();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
