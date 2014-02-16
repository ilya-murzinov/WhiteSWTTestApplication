package com.TestStack.White.SWTTestApplication.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */
public class ListControlsTabView {
    private TabItem listControls;

    private List list;
    private Button changeItemButtons;
    private Combo combo;
    private Combo editableCombo;

    public List getList() {
        return list;
    }

    public Button getChangeItemButtons() {
        return changeItemButtons;
    }

    public Combo getCombo() {
        return combo;
    }

    public Combo getEditableCombo() {
        return editableCombo;
    }

    ListControlsTabView(TabFolder folder) {
        listControls = new TabItem(folder, SWT.NONE);
        listControls.setText("List Controls");
        Composite composite = new Composite(folder, SWT.NONE);
        composite.setLayout(new GridLayout(2, false));
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        list = new List(composite, SWT.V_SCROLL | SWT.BORDER);
        list.setBounds(0,0,50,100);
        combo = new Combo(composite, SWT.READ_ONLY);
        changeItemButtons = new Button(composite, SWT.NONE);
        changeItemButtons.setText("Change Items");
        editableCombo = new Combo(composite, SWT.NONE);

        listControls.setControl(composite);
    }
}
