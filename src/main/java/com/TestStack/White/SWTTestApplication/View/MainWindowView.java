package com.TestStack.White.SWTTestApplication.View;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class MainWindowView {
	private static Display display = new Display();
	private Shell shell;

    private ToolBar toolBar;
	private MenuBarView menu;
	public ListControlsTabView listControlsTab;
	public InputControlsTabView inputControlsTab;
	
	public MainWindowView()	{
        shell = new Shell(display);
		shell.setText("MainWindow");
        GridLayout mainLayout = new GridLayout();
        shell.setLayout(mainLayout);

        menu = new MenuBarView(shell);

		toolBar = new ToolBar(shell, SWT.BAR);
		ToolItem toolBarItem = new ToolItem(toolBar, SWT.NONE);
        toolBarItem.setText("Button in toolbar");
		
		TabFolder folder = new TabFolder(shell, SWT.NONE);
        listControlsTab = new ListControlsTabView(shell, folder);
        inputControlsTab = new InputControlsTabView(shell, folder);

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
