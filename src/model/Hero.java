package model;

import processing.core.PApplet;

public class Hero {
	
	private int pX,pY,dirX,hp;
	private PApplet app;
	
	public Hero(PApplet app) {
		 this.pX= 700/2;
		 this.pY=450;
		 this.dirX = 0;
		 this.app=app;
		 this.hp = 3;
	}
	public void dibujar() {
		this.app.stroke(0);
		this.app.fill(255,0,255);
		this.app.rect(this.pX, this.pY, 50, 50);
	}
	
	public void vida() {
		hp -= 1;
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
	public int getDirX() {
		return dirX;
	}
	public void setDirX(int dirX) {
		this.dirX = dirX;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
}

