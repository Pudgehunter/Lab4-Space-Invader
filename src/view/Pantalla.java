package view;

import controller.ControlThis;
import processing.core.PApplet;

public class Pantalla {
	
	PApplet app;
	ControlThis control;
	
	public Pantalla(PApplet app) {
		this.app = app;
		this.control = new ControlThis(app);
	}
	
	public void controlJuego(){
		control.ejecutar();
	}
	public void controlTeclaHundido() {
		control.teclaHundido();
	}
	public void controlTeclaSuelta() {
		control.teclaSoltado();
	}
	public void controlClick() {
		control.click();
	}
	

}