package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class MainWindowView {
	private Display display;
	private Shell shell;
    private GridLayout mainLayout = new GridLayout();
	private GridLayout layout = new GridLayout();
	
	private Menu menuBar, fileMenu;
	private MenuItem menuHeaderItem;
	private MenuItem menuItem;
	
	private ToolBar toolBar;
	
	public ListControlsTab listControlsTab;
	public InputControlsTab inputControlsTab;
	
	public MainWindowView()	{
		display = new Display();
		
		shell = new Shell(display);
		shell.setText("MainWindow");
		shell.setLayout(mainLayout);
		
		menuBar = new Menu(shell, SWT.BAR);
		menuHeaderItem = new MenuItem(menuBar, SWT.CASCADE);
		menuHeaderItem.setText("File");
		fileMenu = new Menu(shell, SWT.DROP_DOWN);
		menuHeaderItem.setMenu(fileMenu);
		menuItem = new MenuItem(fileMenu, SWT.PUSH);
		menuItem.setText("Click me");
		
		toolBar = new ToolBar(shell, SWT.BAR);
		ToolItem toolBarItem = new ToolItem(toolBar, SWT.PUSH);
		toolBarItem.setText("Button in toolbar");
		
		TabFolder folder = new TabFolder(shell, SWT.NONE);
		
		generateAllTabs(shell, folder);
		
		shell.setMenuBar(menuBar);
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
        private List list;
		private Combo combo;
		private Combo editableCombo;
		
		ListControlsTab(Shell shell, TabFolder folder) {
			listControls = new TabItem(folder, SWT.NONE);
			listControls.setText("List Controls");
			listControlsFolder = new TabFolder(folder, SWT.NONE);
            layout.numColumns = 2;
			listControlsFolder.setLayout(layout);

            list = new List(listControlsFolder, SWT.V_SCROLL | SWT.BORDER);
			combo = new Combo(listControlsFolder, SWT.READ_ONLY);
			editableCombo = new Combo(listControlsFolder, SWT.NONE);
			
			listControls.setControl(listControlsFolder);
		}
		public  void setListItems(String[] items) {
            list.setItems(items);
        }
		public void setComboboxItems(String[] items) {
			combo.setItems(items);
			editableCombo.setItems(items);
		}
	}
	
	public class InputControlsTab {		
		private TabFolder inputControlsFolder;
		private TabItem inputControls;
		
		private Text textBox;
		
		InputControlsTab(Shell shell, TabFolder folder) {
			inputControls = new TabItem(folder, SWT.NONE);
			inputControls.setText("Input Controls");
			inputControlsFolder = new TabFolder(folder, SWT.NONE);
			inputControlsFolder.setLayout(layout);
			
			textBox = new Text(inputControlsFolder, SWT.BORDER);
			
			inputControls.setControl(inputControlsFolder);
		}
		
		public String getTextBox()
		{
			return textBox.getText();
		}
		public void setTextBox(String value)
		{
			textBox.setText(value);
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
