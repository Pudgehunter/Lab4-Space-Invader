package model;

import processing.core.PApplet;

public class Enemy {
	
	private int pX,pY,r,dirX;
	private PApplet app;
	
	public Enemy(PApplet app, int pX, int pY) {
		this.pX = pX;
		this.pY = pY;
		this.r = 30;
		this.dirX = 10;
		this.app = app;
	}

	public void cambio() {
		this.dirX *= -1;
		this.pY += this.r;
	}	
	
	public void reinicio() {
		// TODO Auto-generated method stub
		this.pY = 20;
	}
	
	public void move() {
		this.pX = this.pX + this.dirX;
	}
	
	public void dibujar() {
		this.app.fill(255,255,0);
		this.app.ellipse(this.pX,this.pY, this.r*2, this.r*2);
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

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getDirX() {
		return dirX;
	}

	public void setDirX(int dirX) {
		this.dirX = dirX;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}
	
	

}
