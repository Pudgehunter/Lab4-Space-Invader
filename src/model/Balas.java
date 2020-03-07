package model;

import processing.core.PApplet;

public class Balas {

	private int pX,pY,r;
	private PApplet app;
	private boolean toDelete;
	
	public Balas(PApplet app, int pX, int pY) {
		
		this.pX = pX;
		this.pY = pY;
		this.r = 8;
		this.app = app;
		this.toDelete = false;
		
	}
	
	public void shoot() {
		this.pY = pY - 5;
	}
	
	public void dibujar() {
		this.app.noStroke();
		this.app.fill(0,255,255);
		this.app.ellipse(this.pX, this.pY, this.r*2, this.r*2);
	}
	
	
	public boolean isToDelete() {
		return toDelete;
	}

	public void setToDelete(boolean toDelete) {
		this.toDelete = toDelete;
	}
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
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
	
	public void f() {
		this.toDelete = true;
	}
	
}
