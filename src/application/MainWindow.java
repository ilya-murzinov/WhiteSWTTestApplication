package application;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MainWindow {
	public static void main(String[] args) throws InterruptedException
	{
		Display display = new Display();
		Shell shell = new Shell(display);
		Button button = new Button(shell, SWT.PUSH);
		button.setLocation(new Point(100, 100));
		button.setText("Button");
		button.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
	}
}
