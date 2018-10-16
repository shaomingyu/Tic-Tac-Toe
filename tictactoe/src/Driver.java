import model.*;
import view.*;
import controller.*;

public class Driver {
	public static void main(String[] args) {
		//Initialize Everything

		Model model = new Model();
		View view = new View();
		Controller controller = new Controller();
		
		model.setView(view);
		view.setController(controller);
		controller.setModel(model);
	}
}