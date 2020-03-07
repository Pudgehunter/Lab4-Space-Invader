package view;

import model.logica;
import processing.core.PApplet;

public class main extends PApplet {
	
	Pantalla pantalla;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.main");
	}
	public void settings () {
		size(700,500);
		
	}
	
	public void setup () {
		pantalla = new Pantalla(this);
		
	}
	
	public void draw () {
	background(120,180,350);
	pantalla.controlJuego();;
	
	}
	
	public void mousePressed() {
	pantalla.controlClick();
	}
	
	public void keyPressed() {
	pantalla.controlTeclaHundido();
	}
	
	public void keyReleased() {
	pantalla.controlTeclaSuelta();
	}
		
}
