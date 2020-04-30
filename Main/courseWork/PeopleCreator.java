package courseWork;

public class PeopleCreator {
	
	MenuController values;
	Building B;
	int totaldevs;
	ArrivalSimulator sim;
	

	public PeopleCreator(MenuController m, Building b, ArrivalSimulator s) {
		values = m;
		B = b;
		sim = s;
		totaldevs = values.getMugdevs() + values.getGoggledevs();
		createEmployees();
		//createDevs();
	}
	
	public void createEmployees() {
		for (int i=0; i < values.getEmployees();i++) {
			B.getFloors().get(0).addToQ(new Employees("E"+i,1,B,sim));
		}
	}
	
	public void createDevs() {
		for (int i=0; i < totaldevs;i++) { //later on split this into the two types of devs
			B.getFloors().get(0).addToQ(new Developers("D"+i,1,B));
		}
	}
	

	


}
