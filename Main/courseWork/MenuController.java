package courseWork;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * this class handles anything to do with the UI
 * if a button is clicked or a value is changed etc
 * @author Amrik
 *
 */
public class MenuController {
	
	@FXML
	private Label P;
	
	@FXML
	private Label Q;
	
	@FXML
	private Slider Pslider;
	
	@FXML
	private Slider Qslider;
	
	@FXML
	private Spinner<Integer> seed;
	
	@FXML
	private Spinner<Integer> floors;
	
	@FXML
	private Spinner<Integer> ticks;
	
	@FXML
	private Spinner<Integer> elevatorcap;
	
	@FXML
	private Spinner<Integer> employees;
	
	@FXML
	private Spinner<Integer> mugdevs;
	
	@FXML
	private Spinner<Integer> goggledevs;
	
	@FXML
	private Spinner<Integer> elevators;
	

	public MenuController() {
		
	}
	/**
	 * initialize sets up listeners for the sliders so that if the slider is moved 
	 * then the text will change to show the value of the slider
	 * This function also sets up all the boxes to allow for numbers to be entered 
	 * This is done by creating a Spinner Value Factory for each Spinner
	 */
	@FXML
	public void initialize() {
		Pslider.valueProperty().addListener((prop, oldValue, newValue) -> {
			P.setText(String.format("P: %.2f", newValue));
		});
		
		Qslider.valueProperty().addListener((prop, oldValue, newValue) -> {
			Q.setText(String.format("Q: %.2f", newValue));
		});
		
		SpinnerValueFactory<Integer> values = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000);
		seed.setValueFactory(values);
		SpinnerValueFactory<Integer> floorvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
		floors.setValueFactory(floorvalues);
		SpinnerValueFactory<Integer> tickvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000);
		ticks.setValueFactory(tickvalues);
		SpinnerValueFactory<Integer> elevatorvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000);
		elevatorcap.setValueFactory(elevatorvalues);
		SpinnerValueFactory<Integer> emvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000);
		employees.setValueFactory(emvalues);
		SpinnerValueFactory<Integer> mugvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000);
		mugdevs.setValueFactory(mugvalues);
		SpinnerValueFactory<Integer> gogvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000);
		goggledevs.setValueFactory(gogvalues);
		SpinnerValueFactory<Integer> elvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000);
		elevators.setValueFactory(elvalues);
	}
	
	public int getFloors() {
		return floors.getValue();
	}
	
	public int getElevatorcap() {
		return elevatorcap.getValue();
	}


	public int getElevators() {
		return elevators.getValue();
	}

	public Slider getPslider() {
		return Pslider;
	}

	public Slider getQslider() {
		return Qslider;
	}

	public long getSeed() {
		return seed.getValue();
	}

	public int getTicks() {
		return ticks.getValue();
	}

	public int getEmployees() {
		return employees.getValue();
	}

	public int getMugdevs() {
		return mugdevs.getValue();
	}

	public int getGoggledevs() {
		return goggledevs.getValue();
	}

	/**
	 * when the run button is clicked in the UI the function below specifies what should happen
	 */
	@FXML 
	public void runClicked() {
		Simulation s = new Simulation(this);
		s.run();
	}
	/**
	 * when the runStudy button is clicked in the UI the function below specifies what should happen
	 * A new Simulation class is created and the MenuController which holds all the values the user wants
	 * is given to that class so the values from the UI can be used
	 */
	@FXML
	public void runStudy() {
		Simulation theSimulation = new Simulation(this);
		Study runStudy = new Study(theSimulation);
		runStudy.testStudy();
	}

}
