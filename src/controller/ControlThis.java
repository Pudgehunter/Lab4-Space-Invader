package controller;

import model.logica;
import processing.core.PApplet;

public class ControlThis {
	PApplet app;
	logica logica;
	
	public ControlThis(PApplet app) {
		this.app = app;
		this.logica = new logica(app);
	}
	
	public void ejecutar() {
		logica.logicaEjecutar();;
	}
	
	public void teclaHundido() {
		logica.keyPress();
	}
	
	public void teclaSoltado() {
		logica.keySuelto();
	}
	
	public void click() {
		logica.clicked();
	}
	
	

}
