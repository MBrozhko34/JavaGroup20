package courseWork;

public class PeopleCreator {
	
	MenuController values;
	Building B;
	

	public PeopleCreator(MenuController m, Building b) {
		values = m;
		B = b;
	}
	
	public void createDevs() {
		for (int i=0; i < values.getEmployees();i++) {
			B.getFloors().get(0).addToQ(new Developers("D"+i,1,B));
		}
	}

}
