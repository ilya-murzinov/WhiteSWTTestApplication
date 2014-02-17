package com.TestStack.White.SWTTestApplication.Application;

import com.TestStack.White.SWTTestApplication.Controller.MainWindowController;
import com.TestStack.White.SWTTestApplication.Model.MainWindowModel;
import com.TestStack.White.SWTTestApplication.View.MainWindowView;

/**
 * Main class which contains entry point for application
 */
public class Main {
    /**
     * Entry point for application.
     * Model, view and controller are constructed and view is shown here.
     * @param args command line parameters.
     */
    public static void main(String[] args)
	{
		MainWindowModel model = new MainWindowModel();
		MainWindowView view = new MainWindowView();
		MainWindowController controller =
				new MainWindowController(model, view);
		view.show();
	}
}
