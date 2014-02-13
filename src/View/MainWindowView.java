package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

public class MainWindowView {
	private Display display;
	private Shell shell;
	
	public ListControlsTab listControlsTab;
	public InputControlsTab inputControlsTab;
	
	public MainWindowView()	{
		display = new Display();
		
		shell = new Shell(display);
		shell.setText("MainWindow");
		shell.setLayout(new FillLayout());		
		
		TabFolder folder = new TabFolder(shell, SWT.NONE);
		
		generateAllTabs(shell, folder);
		
		shell.pack();
		shell.setSize(800, 450);
	}
	
	private void generateAllTabs(Shell shell, TabFolder folder) {
		listControlsTab = new ListControlsTab(shell, folder);
		inputControlsTab = new InputControlsTab(shell, folder);
	}
	
	public class ListControlsTab {		
		private TabItem listControls;		
		private TabFolder listControlsFolder;
		private Combo combo;
		private Combo editableCombo;
		
		ListControlsTab(Shell shell, TabFolder folder) {
			listControls = new TabItem(folder, SWT.NONE);
			listControls.setText("List Controls");
			listControlsFolder = new TabFolder(folder, SWT.NONE);
			Rectangle clientArea = listControlsFolder.getClientArea();
			
			combo = new Combo(listControlsFolder, SWT.READ_ONLY);
			combo.setBounds(clientArea.x, clientArea.y, 200, 200);
			editableCombo = new Combo(listControlsFolder, SWT.NONE);
			editableCombo.setBounds(clientArea.x, clientArea.y + combo.getSize().y + 5, 200, 200);
			
			listControls.setControl(listControlsFolder);
		}
		
		public void setComboboxItems(String[] items) {
			combo.setItems(items);
			editableCombo.setItems(items);
		}
	}
	
	public class InputControlsTab {		
		private TabFolder inputControlsFolder;
		private TabItem inputControls;
		
		InputControlsTab(Shell shell, TabFolder folder) {
			inputControls = new TabItem(folder, SWT.NONE);
			inputControls.setText("Input Controls");
			inputControlsFolder = new TabFolder(folder, SWT.NONE);
			Rectangle clientArea = inputControlsFolder.getClientArea();
			
			inputControls.setControl(inputControlsFolder);
		}
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
