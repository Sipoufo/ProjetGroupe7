package com.entity.mobileelements;

import java.io.IOException;

import com.entity.motionlesselements.ExitDoor;
import com.entity.motionlesselements.Path;

import entity.Sprite;

public class Player extends MobileElements {

	//****ATTRIBUTS****//
	private static final Sprite spriteDown = new Sprite('y', "Rockford.png");
	private static final Sprite spriteTurnLeft = new Sprite('y', "Left_Rockford.png");
	private static final Sprite spriteTurnRight = new Sprite('y', "Right_Rockford.png");
	private static final Sprite spriteUp = new Sprite('y', "Back_Rockford1.png");
	private boolean isWin;

	static {
		try {
			spriteDown.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	//****CONSTRUCTOR****//
	public Player(int x, int y) {
		super(spriteDown, x, y);
		this.isAlive = true;
		this.isWin = false;

	}

	
	
	//****GETTERS****//
	public Sprite getSpriteDown() {
		return spriteDown;
	}
	
	public Sprite getSpriteTurnLeft() {
		return spriteTurnLeft;
	}

	public Sprite getSpriteTurnRight() {
		return spriteTurnRight;
	}

	public Sprite getSpriteUp() {
		return spriteUp;
	}
	
	public boolean getIsWin() {
		return isWin;
	}


	
	//****METHODES****//
	public void movePlayer(char direction) {

		if(this.getIsAlive()) {
			switch (direction) {

			case 'Z':
				this.entityMove(0, -1, 0, direction);
				break;
			case 'Q':
				this.entityMove(-1, 0, -1, direction);
				break;
			case 'S':
				this.entityMove(0, +1, 0, direction);
				break;
			case 'D':
				this.entityMove(+1, 0, 1, direction);
				break;
			}
		}
	}
	
	public void setIsWin(boolean isWin) {
		this.isWin = isWin;
	}

	public void playerDeathLinkToEnemy() {
		
		int x = this.getPositionX();
		int y = this.getPositionY();
		
		if(this.getMap().getArrayMap()[x+1][y] instanceof Enemy ||
				this.getMap().getArrayMap()[x-1][y] instanceof Enemy ||
				this.getMap().getArrayMap()[x][y+1] instanceof Enemy ||
				this.getMap().getArrayMap()[x][y-1] instanceof Enemy) {
			this.setIsAlive(false);
			this.loadImage('X', this);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	public void didPlayerWin(int numberOfDiamondsNeeded) {
		
		this.goToExit(0, 1, numberOfDiamondsNeeded);
		this.goToExit(0, -1, numberOfDiamondsNeeded);
		this.goToExit(1, 0, numberOfDiamondsNeeded);
		this.goToExit(-1, 0, numberOfDiamondsNeeded);
		
	}
	
	public void goToExit(int sideX, int sideY, int numberOfDiamondsNeeded) {
		
		int x = this.getPositionX();
		int y = this.getPositionY();

		if(this.getMap().getArrayMap()[x+sideX][y+sideY] instanceof ExitDoor && this.getDiamondsCounter() >= numberOfDiamondsNeeded) {
			this.getMap().getArrayMap()[x+sideX][y+sideY] = this.getMap().getArrayMap()[x][y];
			this.getMap().getArrayMap()[x][y] = new Path(x,y);
			this.setIsWin(true);
		}
	}
	
	
}