package Application;

import View.*;
import Controller.*;
import Model.*;

public class Main {
	public static void main(String[] args)
	{
		MainWindowModel model = new MainWindowModel();
		MainWindowView view = new MainWindowView(model.comboboxItems);
		MainWindowController controller = 
				new MainWindowController(model, view);
		
		view.show();
	}
}
