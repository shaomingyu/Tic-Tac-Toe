import org.junit.Test;
import static org.junit.Assert.*;

import model.*;
import controller.*;
import view.*;

public class ViewTest {
    @Test
    public void testGameState() {
        Controller controller = new Controller();
        View view = new View();
        view.setup();
        view.update(0, 0, 'O', "Test");
        assertEquals("O", view.getButton(0, 0));
         //checks if controller is sending requests to model
    }
}
