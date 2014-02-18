package com.TestStack.White.SWTTestApplication.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by ilya-murzinov on 17.02.14.
 */
public class DataGridTabView {
    private TabItem otherControls;
    private Table table;
    private String[] columnNames;

    public Table getTable() {
        return table;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    DataGridTabView(TabFolder folder) {
        otherControls = new TabItem(folder, SWT.NONE);
        otherControls.setText("Data Grid");
        Composite composite = new Composite(folder, SWT.NONE);
        composite.setLayout(new GridLayout(1, false));
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        table = new Table (composite, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
        table.setLinesVisible (true);
        table.setHeaderVisible (true);
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        data.heightHint = 200;
        table.setLayoutData(data);

        otherControls.setControl(composite);
    }
}
