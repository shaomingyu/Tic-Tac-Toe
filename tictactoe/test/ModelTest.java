import org.junit.Test;
import static org.junit.Assert.*;

import model.*;
import controller.*;
import view.*;

public class ModelTest {
    @Test
    public void testGameState() {
        Model model = new Model();
        View view = new View();
        model.setView(view);
        model.makeMove(1, 1);
        assertEquals(1, model.getTurn());
        assertEquals('X', model.getBoard(1, 1)); //checks if controller is sending requests to model
    }
}
