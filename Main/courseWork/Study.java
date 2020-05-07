package courseWork;

public class Study {
	ArrivalSimulator aSimu; 
	Simulation simu; 
	private int p;
	private int q;

	public Study(Simulation studyS) { 
		simu=studyS;
	}
	
	public void testStudy() {
		for (int i=0; i<5; i++) {
			//aSimu.getPProbability(); 
			//aSimu.getQProbability();
			//aSimu.createCombinations();
			simu.runStudy(p,q); 
			p++;
			q++;
		}
		
		
		
	}

}





