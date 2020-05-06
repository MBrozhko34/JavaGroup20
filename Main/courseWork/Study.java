package courseWork;

public class Study {
	ArrivalSimulator aSimu; 
	Simulation simu; 

	public Study(Simulation studyS) { 
		simu=studyS;
	}
	
	public void testStudy() {
		for (int i=0; i<5; i++) {
			aSimu.getPProbability(); 
			aSimu.getQProbability();
			simu.runStudy(); 
		}
		
		
		
	}

}
