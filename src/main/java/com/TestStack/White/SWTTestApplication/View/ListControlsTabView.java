package com.TestStack.White.SWTTestApplication.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseListener;
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

    ListControlsTabView(TabFolder folder) {
        listControls = new TabItem(folder, SWT.NONE);
        listControls.setText("List Controls");
        Composite composite = new Composite(folder, SWT.NONE);
        composite.setLayout(new GridLayout(2, false));
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

        list = new List(composite, SWT.V_SCROLL | SWT.BORDER);
        combo = new Combo(composite, SWT.READ_ONLY);
        changeItemButtons = new Button(composite, SWT.NONE);
        changeItemButtons.setText("Change Items");
        editableCombo = new Combo(composite, SWT.NONE);

        listControls.setControl(composite);
    }
    public  void setListItems(String[] items) {
        list.setItems(items);
    }

    public void setChangeItemButtonMouseListener(MouseListener value) {
        changeItemButtons.addMouseListener(value);
    }

    public Button getChangeItemButtons() {
        return changeItemButtons;
    }

    public void setComboboxItems(String[] items) {
        combo.setItems(items);
        editableCombo.setItems(items);
    }

    public void selectItemCombo(int index) {
        combo.select(index);
    }

    public int getSelectionIndexCombo() {
        return combo.getSelectionIndex();
    }

    public String[] getListItems() {
        return list.getItems();
    }
}
