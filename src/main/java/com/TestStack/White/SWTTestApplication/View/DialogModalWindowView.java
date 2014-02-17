package com.TestStack.White.SWTTestApplication.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Class represents modal window.
 *
 * @author Murzinov Ilya
 */
public class DialogModalWindowView {
    Shell dialogShell;
    Display display = MainWindowView.getDisplay();

    Button closeButton;

    public Shell getDialogShell() {
        return dialogShell;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public DialogModalWindowView() {
        dialogShell = new Shell(display, SWT.PRIMARY_MODAL | SWT.SHEET);
        dialogShell.setLayout(new GridLayout());

        closeButton = new Button(dialogShell, SWT.PUSH);
        closeButton.setText("Close me");
        dialogShell.setDefaultButton(closeButton);
        dialogShell.pack();
        dialogShell.setSize(200, 200);
    }

    public void show() {
        dialogShell.open();
        while (!dialogShell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}
