package model;

import processing.core.PApplet;

public class Hero {
	
	private int pX,pY,dirX;
	private PApplet app;
	
	public Hero(PApplet app) {
		 this.pX= 700/2;
		 this.pY=450;
		 this.dirX = 0;
		 this.app=app;
	}
	public void dibujar() {
		this.app.stroke(0);
		this.app.fill(255,0,255);
		this.app.rect(this.pX, this.pY, 50, 50);
	}
	
	public void movimientoSuave(int dirX) {
		this.dirX = dirX;
	}
	
	public void mover() {
		this.pX += dirX*5;
	}
	
	public int getpX() {
		return pX;
	}
	public void setpX(int pX) {
		this.pX = pX;
	}
	public int getpY() {
		return pY;
	}
	public void setpY(int pY) {
		this.pY = pY;
	}
	public PApplet getApp() {
		return app;
	}
	public void setApp(PApplet app) {
		this.app = app;
	}
	
}

