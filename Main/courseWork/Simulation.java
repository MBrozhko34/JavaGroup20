package courseWork;

import java.util.Random;

//import javafx.application.Application;

public class Simulation {
	
	MenuController MenuVars;
	TextBasedUI Ui;
	public int tick;


	public Simulation(MenuController m) {
		MenuVars = m;
		tick = 0;

	}
	

	public void run() {
		Building building1 = new Building(MenuVars,this);
		Random randomness = new Random(20);
		ArrivalSimulator s = new ArrivalSimulator(randomness);
		PeopleCreator p = new PeopleCreator(MenuVars, building1,s,randomness);
		Ui = new TextBasedUI(building1,this);
		Ui.showUI();
		
		for (int i=0; i< MenuVars.getTicks();i++) {
			building1.tick();
			p.tick();
			Ui.showUI();
			tick++;
		}
	}
}
