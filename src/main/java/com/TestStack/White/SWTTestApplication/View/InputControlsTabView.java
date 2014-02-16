package com.TestStack.White.SWTTestApplication.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */
public class InputControlsTabView {

    private Text textBox;

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
