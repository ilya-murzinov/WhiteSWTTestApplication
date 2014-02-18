package com.TestStack.White.SWTTestApplication.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/**
 * Represents main window.
 * All other objects are created and combined together in this class.
 *
 * @author Murzinov Ilya
 */
public class MainWindowView {
	private static Display display = new Display();
	private Shell shell;
    private TabFolder folder;

    private ToolBar toolBar;
    private ToolItem toolBarItem;
	private MenuBarView menu;

    //Only TabViews should be public
    /**
     * Tab with list controls
     */
    public ListControlsTabView listControlsTab;
    /**
     * Tab with input controls
     */
    public InputControlsTabView inputControlsTab;
    /**
     * Tab with other controls
     */
    public OtherControlsTabView otherControlsTab;
    /**
     * Tab with data grid
     */
    public DataGridTabView dataGridTab;
    /**
     * Tab with buttons
     */
    public ScenariosTabView scenariosTab;

    /**
     * This is the main constructor of View.
     * It combines together all other *View objects into the shell.
     *
     */
	public MainWindowView()	{
        shell = new Shell(display);
		shell.setText("MainWindow");
        shell.setLayout(new GridLayout(2, false));
        folder = new TabFolder(shell, SWT.FILL);

        menu = new MenuBarView(shell);

        scenariosTab = new ScenariosTabView(shell);

        //TODO: somehow toolbar moved to bottom, this needs to be fixed
        toolBar = new ToolBar(shell, SWT.FLAT | SWT.WRAP | SWT.RIGHT);
        GridData data = new GridData();
        data.horizontalSpan = 2;
        toolBar.setLayoutData(data);
		toolBarItem = new ToolItem(toolBar, SWT.CHECK);
        toolBarItem.setText("Button in toolbar");

        folder.setLayout(new GridLayout());
        folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        listControlsTab = new ListControlsTabView(folder);
        inputControlsTab = new InputControlsTabView(folder);
        otherControlsTab = new OtherControlsTabView(folder);
        dataGridTab = new DataGridTabView(folder);

		shell.pack();
		shell.setSize(800, 450);
	}

    /**
     * Displays resulting shell.
     */
	public void show() {
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
	}

    public static Display getDisplay() {
        return display;
    }

    public ToolItem getToolBarItem() {
        return toolBarItem;
    }

    public ToolBar getToolBar() {
        return toolBar;
    }

    public TabFolder getFolder() {
        return folder;
    }
}
