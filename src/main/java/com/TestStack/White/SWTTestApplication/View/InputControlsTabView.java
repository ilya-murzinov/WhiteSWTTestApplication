package com.TestStack.White.SWTTestApplication.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */
public class InputControlsTabView {
    private TabFolder inputControlsFolder;
    private TabItem inputControls;
    protected GridLayout layout = new GridLayout();

    private Text textBox;

    InputControlsTabView(Shell shell, TabFolder folder) {
        inputControls = new TabItem(folder, SWT.NONE);
        inputControls.setText("Input Controls");
        inputControlsFolder = new TabFolder(folder, SWT.NONE);
        inputControlsFolder.setLayout(layout);

        textBox = new Text(inputControlsFolder, SWT.BORDER);

        inputControls.setControl(inputControlsFolder);
    }

    public String getTextBoxText()
    {
        return textBox.getText();
    }
    public void setTextBoxText(String value)
    {
        textBox.setText(value);
    }
}
