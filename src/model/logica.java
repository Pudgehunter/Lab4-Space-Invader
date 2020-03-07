package model;

import static processing.core.PConstants.LEFT;
import static processing.core.PConstants.RIGHT;

import java.util.ArrayList;

import model.Enemy;
import model.Hero;
import processing.core.PApplet;

public class logica {
	
	public PApplet app;
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
	

	public logica(PApplet app) {
		// Pantallas
		this.app = app;
		pantalla = 0;
		// El jugador que vas a jugar.
		hero = new Hero(app);	
		//Los enemigos que solamente quiero 6 enemigos
		listEnemy = new ArrayList<Enemy>();
		listSizeEnemy = 6;
		for(int i=0;i<listSizeEnemy;i++){
			listEnemy.add(new Enemy(app,20+(i*100),50));
		}
		
		// Las infinitas del jugador.
		listBalas = new ArrayList<Balas>();
		listBalas.add(new Balas(app,0,0));
	}
	
	
	public void logicaEjecutar() {
		
		switch (pantalla) {
		case 0:
			app.background(255);
			app.fill(0);
			app.textSize(50);
			app.text("Welcome to Space Invaders",20,100);
			app.textSize(40);
			//size(700,500);
			if(app.mouseX > app.width/2-40 && app.mouseX <= app.width/2+45 && app.mouseY > app.height-250 && app.mouseY <= app.height-200) {
				app.fill(255,0,0);
			}
			app.text("Start",app.width/2-40, app.height-200);
			app.fill(0);
			if(app.mouseX > app.width/2-40 && app.mouseX <= app.width/2+40 && app.mouseY > app.height-150 && app.mouseY <= app.height-100) {
				app.fill(255,0,0);
			}
			app.text("Exit",app.width/2-40,app.height-100);
			
			break;
		case 1:
			app.background(52);
			
			//dibujar mi personaje
			hero.dibujar();
			hero.mover();
			
			//dibujar los enemigos con un for para que se repita
			corner = false;
			reinicio = false;
			for (int i = 0; i < listEnemy.size(); i++) {
				listEnemy.get(i).dibujar();
				listEnemy.get(i).move();
				if(listEnemy.get(i).getpX() > app.width || listEnemy.get(i).getpX() < 0) {
					corner = true;
				}
				if(listEnemy.get(i).getpY() > app.height) {
					reinicio = true;
				}
				app.text("Vida ="+hero.getHp(),500,100);
				float a = PApplet.dist(listEnemy.get(i).getpX(),
						listEnemy.get(i).getpY(),
						hero.getpX(),
						hero.getpY());
				if(a < 55) {
					app.background(255);
					hero.vida();
					listEnemy.remove(i);
					if(hero.getHp() == 0) {
						pantalla = 3;
					}
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
					float d = PApplet.dist(listBalas.get(i).getpX(),listBalas.get(i).getpY(),listEnemy.get(j).getpX(),listEnemy.get(j).getpY());
					if(d < listBalas.get(i).getR() + listEnemy.get(j).getR()){
						
						if(listBalas == null || listBalas.size() == 0) {
							listBalas.add(new Balas(app,hero.getpX()+25,hero.getpY()));
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
			app.background(255);
			app.fill(0);
			app.textSize(50);
			app.text("You win",app.width/2-100,app.height/2);
	
			break;
		case 3:
			app.background(255);
			app.fill(0);
			app.textSize(50);
			app.text("You lose",app.width/2-100,app.height/2);
			break;

		default:
			break;
		}
		
	}
	

	public void keySuelto() {
		if(app.keyCode != ' ') {
		hero.movimientoSuave(0);
		}
	}
	
	public void keyPress() {
		if(app.keyCode == ' ') {
			listBalas.add(new Balas(app,hero.getpX()+25,hero.getpY()));

		}
		
		if(app.keyCode == LEFT) {
			if(hero.getpX() > 0) {
			hero.movimientoSuave(-1);
			} else {
				hero.movimientoSuave(0);
			}
			
		}else if(app.keyCode == RIGHT){
			if(hero.getpX() < 650) {
				hero.movimientoSuave(+1);
			} else {
				hero.movimientoSuave(0);
			}
		}
	}
	
	public void clicked() {
		switch(pantalla) {
		case 0:
			if(app.mouseX > app.width/2-40 && app.mouseX <= app.width/2+45 && app.mouseY > app.height-250 && app.mouseY <= app.height-200) {
				pantalla = 1;
			}
			if(app.mouseX > app.width/2-40 && app.mouseX <= app.width/2+40 && app.mouseY > app.height-150 && app.mouseY <= app.height-100) {
				app.exit();
			}
			break;
		case 1:
			break;
			
		}
	}


	public PApplet getApp() {
		return app;
	}


	public void setApp(PApplet app) {
		this.app = app;
	}


	public int getPantalla() {
		return pantalla;
	}


	public void setPantalla(int pantalla) {
		this.pantalla = pantalla;
	}


	public boolean isTieneMunicion() {
		return tieneMunicion;
	}


	public void setTieneMunicion(boolean tieneMunicion) {
		this.tieneMunicion = tieneMunicion;
	}


	public Hero getHero() {
		return hero;
	}


	public void setHero(Hero hero) {
		this.hero = hero;
	}


	public ArrayList<Enemy> getListEnemy() {
		return listEnemy;
	}


	public void setListEnemy(ArrayList<Enemy> listEnemy) {
		this.listEnemy = listEnemy;
	}


	public int getListSizeEnemy() {
		return listSizeEnemy;
	}


	public void setListSizeEnemy(int listSizeEnemy) {
		this.listSizeEnemy = listSizeEnemy;
	}


	public ArrayList<Balas> getListBalas() {
		return listBalas;
	}


	public void setListBalas(ArrayList<Balas> listBalas) {
		this.listBalas = listBalas;
	}


	public boolean isCorner() {
		return corner;
	}


	public void setCorner(boolean corner) {
		this.corner = corner;
	}


	public boolean isReinicio() {
		return reinicio;
	}


	public void setReinicio(boolean reinicio) {
		this.reinicio = reinicio;
	}
	

}
	
