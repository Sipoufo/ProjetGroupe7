package controller;

import Element.Type;
import Personnage.Hero;
import contract.IController;
import model.IInsanePersonModel;
import view.IIsanePersonView;

public final class Controller implements IController {
	//****ATTRIBUTS****//
	private IInsanePersonModel model;
	private IIsanePersonView view;
	private Hero hero;
	
	
	
	//****CONSTRUCTOR****//
	public Controller(IInsanePersonModel model, IIsanePersonView view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	
	
	//****GETTERS****//
	public IInsanePersonModel getModel() {
		return model;
	}

	public IIsanePersonView getView() {
		return view;
	}
	
	
	
	//****SETTERS****//
	public void setModel(IInsanePersonModel model) {
		this.model = model;
	}

	public void setView(IIsanePersonView view) {
		this.view = view;
	}
	
	
	
	//****METHODES****//
	public void control() {
		view.setNiveau(1);
	}
	
	public void Deplacement() {
		if(model.getRoad().getElementRoadXY(2, 2).getType() == Type.HARD) {
			
		}
	}
	
}
