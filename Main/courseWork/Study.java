package courseWork;

/**
 * runs the simulation numerous times with different values of p and q
 * this is done by getting different values from the arrays that hold all of the 
 * values that p and q could be
 * @author amrik
 *
 */

public class Study {
	public ArrivalSimulator aSimu; 
	public Simulation simu; 
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





