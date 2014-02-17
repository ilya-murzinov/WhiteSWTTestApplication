package com.TestStack.White.SWTTestApplication.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/**
 * Represents main window.
 * All other are created objects are combined together in this class.
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
	public ListControlsTabView listControlsTab;
	public InputControlsTabView inputControlsTab;
    public OtherControlsTabView otherControlsTab;
    public DataGridTabView dataGridTab;
	
	public MainWindowView()	{
        shell = new Shell(display);
		shell.setText("MainWindow");
        shell.setLayout(new GridLayout(1, false));
        folder = new TabFolder(shell, SWT.FILL);

        menu = new MenuBarView(shell);

        //TODO: somehow toolbar moved to bottom, this needs to be fixed
        toolBar = new ToolBar(shell, SWT.BAR | SWT.TOP);
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
	
	public void show() {
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
	}

    public void setToolBarMouseListener(MouseListener value) {
        toolBar.addMouseListener(value);
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
