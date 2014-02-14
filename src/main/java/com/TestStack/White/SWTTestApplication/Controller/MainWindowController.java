package com.TestStack.White.SWTTestApplication.Controller;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */
import com.TestStack.White.SWTTestApplication.View.*;
import com.TestStack.White.SWTTestApplication.Model.*;

public class MainWindowController {
	private MainWindowView view;
	private MainWindowModel model;
	
	public MainWindowController(MainWindowModel model, MainWindowView view) {
		this.view = view;
		this.model = model;
		view.listControlsTab.setComboboxItems(model.comboboxItems);
		view.inputControlsTab.setTextBoxText("123");
        view.listControlsTab.setListItems(model.listItems);
	}
}