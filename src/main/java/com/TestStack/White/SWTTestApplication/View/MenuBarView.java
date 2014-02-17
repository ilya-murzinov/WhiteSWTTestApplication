package com.TestStack.White.SWTTestApplication.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

/**
 * Class represents menu bar in MainWindow
 *
 * @author Murzinov Ilya
 */
public class MenuBarView {
    private Menu menuBar, fileMenu;
    private MenuItem menuHeaderItem;
    private MenuItem menuItem;

    MenuBarView(Shell shell)
    {
        menuBar = new Menu(shell, SWT.BAR);
        menuHeaderItem = new MenuItem(menuBar, SWT.CASCADE);
        menuHeaderItem.setText("File");
        fileMenu = new Menu(shell, SWT.DROP_DOWN);
        menuHeaderItem.setMenu(fileMenu);
        menuItem = new MenuItem(fileMenu, SWT.PUSH);
        menuItem.setText("Click me");
        shell.setMenuBar(menuBar);
    }
}
