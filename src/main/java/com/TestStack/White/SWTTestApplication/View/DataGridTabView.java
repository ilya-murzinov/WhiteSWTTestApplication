package com.TestStack.White.SWTTestApplication.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

/**
 * Created by ilya-murzinov on 17.02.14.
 */
public class DataGridTabView {
    private TabItem otherControls;

    DataGridTabView(TabFolder folder) {
        otherControls = new TabItem(folder, SWT.NONE);
        otherControls.setText("Data Grid");
        Composite composite = new Composite(folder, SWT.NONE);
        composite.setLayout(new GridLayout(2, false));
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        otherControls.setControl(composite);
    }
}
