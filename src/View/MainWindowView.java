package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class MainWindowView {
	private Display display;
	private Shell shell;
	
	private TabItem listControls;
	private TabItem inputControls;
	
	private TabFolder listControlsFolder;
	private TabFolder inputControlsFolder;
	
	private Combo combo;
	
	public MainWindowView(String[] comboboxItems)	{
		display = new Display();
		
		shell = new Shell(display);
		shell.setText("MainWindow");
		shell.setLayout(new org.eclipse.swt.layout.FillLayout());
		
		TabFolder folder = new TabFolder(shell, SWT.NONE);
		listControls = new TabItem(folder, SWT.NONE);
		listControls.setText("List Controls");
		listControlsFolder = new TabFolder(folder, SWT.NONE);
		inputControls = new TabItem(folder, SWT.NONE);
		inputControls.setText("Input Controls");
		inputControlsFolder = new TabFolder(folder, SWT.NONE);
		
		combo = new Combo(listControlsFolder, SWT.READ_ONLY);
		combo.setItems(comboboxItems);
		Rectangle clientArea = shell.getClientArea();
		combo.setBounds (clientArea.x, clientArea.y, 200, 200);
		combo.setData("AUTOMATIONID", "AComboBox");
		
		listControls.setControl(listControlsFolder);
		shell.pack();
		shell.setSize(800, 450);
	}
	
	public void show() {
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
	}
}
