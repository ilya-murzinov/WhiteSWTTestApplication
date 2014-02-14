package com.TestStack.White.SWTTestApplication.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */
public class ListControlsTabView {
    private TabItem listControls;
    private TabFolder listControlsFolder;
    protected GridLayout layout = new GridLayout();
    private List list;
    private Combo combo;
    private Combo editableCombo;

    ListControlsTabView(Shell shell, TabFolder folder) {
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
