module courseWork {
	
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires java.desktop;
	
	exports courseWork;
	
	opens courseWork to javafx.fxml;

}