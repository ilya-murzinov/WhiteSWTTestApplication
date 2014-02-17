package com.TestStack.White.SWTTestApplication.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

/**
 * Represents group with buttons for different scenarios.
 *
 * @author Murzinov Ilya
 */
public class ScenariosTabView {
    private Button button;

    public Button getButton() {
        return button;
    }

    ScenariosTabView(Shell shell) {
        Composite scenarios = new Group(shell, SWT.BORDER);
        scenarios.setLayout(new GridLayout());
        scenarios.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        button = new Button(scenarios, SWT.PUSH);
        button.setText("Open Dialog");
    }
}
