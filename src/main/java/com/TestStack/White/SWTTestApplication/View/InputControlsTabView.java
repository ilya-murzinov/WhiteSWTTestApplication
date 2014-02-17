package com.TestStack.White.SWTTestApplication.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

/**
 * Class represents tab with input controls
 *
 * @author Murzinov Ilya
 */
public class InputControlsTabView {

    private Text textBox;

    /**
     * Constructs inputControlsTab, sets layout and places all controls in it
     * @param folder - parent control in which this tab will be placed
     */
    InputControlsTabView(TabFolder folder) {
        TabItem inputControls = new TabItem(folder, SWT.NONE);
        inputControls.setText("Input Controls");
        Composite composite = new Composite(folder, SWT.NONE);
        composite.setLayout(new GridLayout());
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

        textBox = new Text(composite, SWT.BORDER);

        inputControls.setControl(composite);
    }

    public Text getTextBox()
    {
        return textBox;
    }
}
