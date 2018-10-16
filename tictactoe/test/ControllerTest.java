import org.junit.Test;
import static org.junit.Assert.*;

import model.*;
import controller.*;
import view.*;

public class ControllerTest {
    @Test
    public void testGameState() {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller();
        model.setView(view);
        controller.setModel(model);

        model.setTurn(5);
        assertEquals(5, controller.getTurn()); //checks if controller is sending requests to model
    }
}
