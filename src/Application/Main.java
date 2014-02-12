package Application;

import View.*;
import Controller.*;

public class Main {
	public static void main(String[] args)
	{
		MainWindowView view = new MainWindowView();
		MainWindowController controller = 
				new MainWindowController(view);
		
		view.show();
	}
}
