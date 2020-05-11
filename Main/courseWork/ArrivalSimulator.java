package courseWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class deals generating probability using values assigned for 'P' and 'Q'. It also creates 
 * combinations using 'P' and 'Q' values.
 */

public class ArrivalSimulator {
	private double P_probability;
	private double Q_probability;
	
	private final int pValue;
	private final int qValue;
	
	private List<Double> pList = new ArrayList<>();
	private List<Double> qList = new ArrayList<>();
	
//	private float ArrivalProbability;
//	private float LeaveProbability;
	
	private Random random;
	
	/**
	 * This constructor is used to call on the function that generate the probability values
	 * of 'P' and 'Q' and randomly select them.
	 * 
	 * @param random creates an instance of the Random class
	 * @param p is assigning a value to originally initialised private pValue
	 * @param q is assigning a value to originally initialised private qValue
	 */
	public ArrivalSimulator(Random random, int p, int q) {
		this.random = random;
		pValue=p;
		qValue=q;
		generatePProbability();
		generateQProbability();
	}
	
	/**
	 * This function adds the various probability values to 'P'
	 */
	public void generatePProbability() {
		pList.add(0.001);
		pList.add(0.002);
		pList.add(0.003);
		pList.add(0.004);
		pList.add(0.005);
	}
	
	/**
	 * This function adds the various probability values to 'Q'
	 */
	public void generateQProbability() {
		qList.add(0.002);
		qList.add(0.004);
		qList.add(0.006);
		qList.add(0.008);
		qList.add(0.01);
	}
	
	/**
	 * This function gets the pValue from the pList of all possible 'P' probability values and 
	 * determines whether people want to move by comparing whether the the value 
	 * the probability value is larger than the generated double. 
	 * 
	 * @return false if the P probability value is less than the double value.
	 */
	public boolean getPProbability() {
		Double nextdouble;
		//P_probability=pList.get(random.nextInt(pList.size()));
		P_probability=pList.get(pValue);
		nextdouble = random.nextDouble();
		if (P_probability>nextdouble) {
			return true;
		}
		return false;
	}
	
	public double getThePProbability() {
		getPProbability();
		return P_probability;
	}
	
	/**
	 * This function gets the qValue from the qList of all possible 'Q' probability values.
	 * 
	 * @return the Q probability.
	 */
	public double getQProbability() {
		//Q_probability=qList.get(random.nextInt(qList.size()));
		Q_probability=qList.get(qValue);
		return Q_probability;
	}
	
	/**
	 * This function is used to create all possible combinations from 'P' and 'Q' by iterating
	 * through each probability value. 
	 */
	public void createCombinations() {
		int i = 0;
		while(i<4) {
			int j = 0;
			while(j<4) {
				System.out.println(pList.get(i));
				System.out.println(qList.get(j));
				j++;
			}
		i++;
		}
		
	}
}






