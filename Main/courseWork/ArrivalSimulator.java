package courseWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrivalSimulator {
	private double P_probability;
	private double Q_probability;
	
	private List<Double> pList = new ArrayList<>();
	private List<Double> qList = new ArrayList<>();
	
//	private float ArrivalProbability;
//	private float LeaveProbability;
	
	private Simulation simulation;
	private Random random;
	
	public ArrivalSimulator(Simulation simulation, Random random) {
		this.random = random;
		this.simulation=simulation;
	}
	
//	public void setArrivalProbability(float a) {
//		this.ArrivalProbability=a;
//	}
//	
//	public float getArrivalProbability() {
//		return ArrivalProbability;
//	}
//	
//	public void setLeaveProbability(float l) {
//		this.LeaveProbability=l;
//	}
//	
//	public float getLeaveProbability() {
//		return LeaveProbability;
//	}
	
	public void generatePProbability() {
		pList.add(0.001);
		pList.add(0.002);
		pList.add(0.003);
		pList.add(0.004);
		pList.add(0.005);
	}
	
	public void generateQProbability() {
		qList.add(0.002);
		qList.add(0.004);
		qList.add(0.006);
		qList.add(0.008);
		qList.add(0.01);
	}
	
	public double getPProbability() {
		generatePProbability();
		Random rand1 = new Random();
		P_probability=pList.get(rand1.nextInt(pList.size()));
		System.out.println(P_probability);
		return P_probability;
	}
	
	public double getQProbability() {
		generateQProbability();
		Random rand2 = new Random();
		Q_probability=qList.get(rand2.nextInt(qList.size()));
		System.out.println(Q_probability);
		return P_probability;
	}
	
	//test change to test Michaels PC
}
