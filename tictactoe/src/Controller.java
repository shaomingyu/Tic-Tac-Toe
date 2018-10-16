package controller;

import model.*;
import view.*;

public class Controller {
	private Model model;

	public void setModel(Model m) {
		this.model = m;
	}

	public void sendMove(int x, int y) {
		model.makeMove(x, y);
	}

	public void resetModel() {
		model.reset();
	}
}