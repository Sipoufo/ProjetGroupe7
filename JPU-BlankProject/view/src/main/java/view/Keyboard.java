package view;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	InsanePersonView pview;
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			//System.out.println(pview.getHero().isAlive());
			pview.getHero().setX(pview.getHero().getX() + 32);
			
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent arg0) {
		
	}
}
