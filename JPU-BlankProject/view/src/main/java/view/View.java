package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The View class.
 * @author Groupe 7 : Sipoufo, Regina, Christ, Wilfrid
 * @version 1.0
 *
 */

public final class View implements IView, Runnable {

	
	private ViewFrame viewFrame = null; /** return view frame to null */

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}
	
	public View() {
		
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code 
	 * @return the controller order
	 */
	
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_Z:
				return ControllerOrder.Z;	
			case KeyEvent.VK_Q:
				return ControllerOrder.Q;
			case KeyEvent.VK_S:
				return ControllerOrder.S;
			case KeyEvent.VK_D:
				return ControllerOrder.D;
			default:
				return ControllerOrder.nothing;
		}
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	
	public void printMessage(final String message) {
		
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
			this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}

