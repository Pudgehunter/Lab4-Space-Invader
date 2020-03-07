package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class main extends PApplet {

	
	int pantalla;
	boolean tieneMunicion;
	
	// Tu personaje
	Hero hero;
	
	//Tus enemigos (El primer intento de enemy)
	//Enemy[] enemy = new Enemy[6];
	
	//Nuevo enemy para poder eliminar enemigos
	private ArrayList<Enemy>listEnemy;
	int listSizeEnemy;
	
	//Tus balas infinitas
	private ArrayList<Balas>listBalas;
	
	//Cambio le lados para los enemigos?
	boolean corner;
	boolean reinicio;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("model.main");
	}
	
	
	public void settings() {
		//tamaño de lienzo
		size(700,500);
	}
	
	
	public void setup() {
		
		// Pantallas
		pantalla = 1;
		
		// El jugador que vas a jugar.
		hero = new Hero(this);
		
		// las repeticiones de los enemigos
		/*for (int i = 0; i < enemy.length; i++) {
			enemy[i] = new Enemy(this,50+(i*80),50);
		}*/
		
		//nuevos enemigos
		tieneMunicion = true;
		listEnemy = new ArrayList<Enemy>();
		listSizeEnemy = 6;
		for(int i=0;i<listSizeEnemy;i++){
			listEnemy.add(new Enemy(this,20+(i*100),50));
		}
		
		// Las infinitas del jugador.
		listBalas = new ArrayList<Balas>();
		listBalas.add(new Balas(this,0,0));
	}
	
	
	public void draw() {
		
		switch (pantalla) {
		case 0:
			background(255);
			fill(0);
			textSize(50);
			text("Welcome to Space Invaders",20,100);
			textSize(40);
			//size(700,500);
			if(mouseX > width/2-40 && mouseX <= width/2+45 && mouseY > height-250 && mouseY <= height-200) {
				fill(255,0,0);
			}
			text("Start",width/2-40, height-200);
			fill(0);
			if(mouseX > width/2-40 && mouseX <= width/2+40 && mouseY > height-150 && mouseY <= height-100) {
				fill(255,0,0);
			}
			text("Exit",width/2-40,height-100);
			
			break;
		case 1:
			background(52);
			
			//dibujar mi personaje
			hero.dibujar();
			hero.mover();
			
			//dibujar los enemigos con un for para que se repita
			corner = false;
			reinicio = false;
			for (int i = 0; i < listEnemy.size(); i++) {
				listEnemy.get(i).dibujar();
				listEnemy.get(i).move();
				if(listEnemy.get(i).getpX() > width || listEnemy.get(i).getpX() < 0) {
					corner = true;
				}
				if(listEnemy.get(i).getpY() > height) {
					reinicio = true;
				}
			}
			
			if(corner) {
				for (int i = 0; i < listEnemy.size(); i++) {
					listEnemy.get(i).cambio();
				}
			}
			if(reinicio) {
				for (int i = 0; i < listEnemy.size(); i++) {
					listEnemy.get(i).reinicio();
				}
			}
			
			//Infinitos de balas y confirmar la distancia de la bala con el enemigo
			for (int i = 0; i < listBalas.size(); i++) {
				listBalas.get(i).dibujar();
				listBalas.get(i).shoot();
				for (int j = 0; j < listEnemy.size(); j++) {
					/*if(listBalas.get(i).getpY() <= 50) {
						if(listBalas.size() > 1) {
						listBalas.remove(i);
						tieneMunicion = true;
						}
					}*/
					float d = dist(listBalas.get(i).getpX(),listBalas.get(i).getpY(),listEnemy.get(j).getpX(),listEnemy.get(j).getpY());
					if(d < listBalas.get(i).getR() + listEnemy.get(j).getR()){
						if(listBalas == null || listBalas.size() == 0) {
							listBalas.add(new Balas(this,hero.getpX()+25,hero.getpY()));
						} else {
							//listBalas.remove(i);
						}
						listEnemy.remove(j);
						}
					}
				}
			
	
			
			if(listEnemy.size() == 0) {
				pantalla = 2;
			}
			
			break;
		case 2:
			background(255);
			fill(0);
			textSize(50);
			text("You win",width/2-100,height/2);
	
			break;

		default:
			break;
		}
		
	}
	

	public void keyReleased() {
		if(keyCode != ' ') {
		hero.movimientoSuave(0);
		}
	}
	
	public void keyPressed() {
		if(keyCode == ' ') {
			listBalas.add(new Balas(this,hero.getpX()+25,hero.getpY()));

		}
		
		if(keyCode == LEFT) {
			hero.movimientoSuave(-1);
		}else if(keyCode == RIGHT){
			hero.movimientoSuave(+1);
		}
	}
	
	public void mouseClicked() {
		switch(pantalla) {
		case 0:
			if(mouseX > width/2-40 && mouseX <= width/2+45 && mouseY > height-250 && mouseY <= height-200) {
				pantalla = 1;
			}
			if(mouseX > width/2-40 && mouseX <= width/2+40 && mouseY > height-150 && mouseY <= height-100) {
				exit();
			}
			break;
		case 1:
			break;
			
		}
	}

}
