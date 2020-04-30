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
	
	private Random random;
	
	public ArrivalSimulator(Random random) {
		this.random = random;
		generatePProbability();
		generateQProbability();
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
	
	public boolean getPProbability() {
		P_probability=pList.get(random.nextInt(pList.size()));
		Double nextdouble = 0.00000001;//random.nextDouble();
		if (P_probability>nextdouble) {
			System.out.println("P value: "+P_probability+"Random Value "+nextdouble);
			return true;
		}
		System.out.println("P value: "+P_probability+"Random Value "+nextdouble);
		return false;
	}
	
	public double getQProbability() {
		Q_probability=qList.get(random.nextInt(qList.size()));
		System.out.println(Q_probability);
		return P_probability;
	}
	
	//test change to test Michaels PC
}
