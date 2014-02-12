package View;

import org.eclipse.swt.widgets.*;

public class MainWindowView {
	private Display display = new Display();
	private Shell shell;
	
	public MainWindowView()
	{
		shell = new Shell(display);
		shell.setText("MainWindow");
		shell.setSize(300, 200);
	}
	
	public void show()
	{
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
	}
}
