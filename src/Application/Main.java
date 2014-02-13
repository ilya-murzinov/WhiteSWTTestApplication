package Application;

import View.*;
import Controller.*;
import Model.*;

public class Main {
	public static void main(String[] args)
	{
		MainWindowModel model = new MainWindowModel();
		MainWindowView view = new MainWindowView();
		MainWindowController controller = 
				new MainWindowController(model, view);
		
		view.show();
	}
}
