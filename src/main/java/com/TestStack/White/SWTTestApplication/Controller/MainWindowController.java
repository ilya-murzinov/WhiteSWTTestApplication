/**
 * Created by Murzinov Ilya on 2/14/14.
 */
package main.java.com.TestStack.White.SWTTestApplication.Controller;

import main.java.com.TestStack.White.SWTTestApplication.View.MainWindowView;
import main.java.com.TestStack.White.SWTTestApplication.Model.*;

public class MainWindowController {
	private MainWindowView view;
	private MainWindowModel model;
	
	public MainWindowController(MainWindowModel model, MainWindowView view) {
		this.view = view;
		this.model = model;
		view.listControlsTab.setComboboxItems(model.comboboxItems);
		view.inputControlsTab.setTextBox("123");
        view.listControlsTab.setListItems(model.listItems);
	}
}