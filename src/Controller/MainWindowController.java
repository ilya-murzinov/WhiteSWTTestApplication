package Controller;

import View.MainWindowView;
import Model.*;

public class MainWindowController {
	private MainWindowView view;
	private MainWindowModel model;
	
	public MainWindowController(MainWindowModel model, MainWindowView view) {
		this.view = view;
		this.model = model;
		view.listControlsTab.setComboboxItems(model.comboboxItems);
	}
}