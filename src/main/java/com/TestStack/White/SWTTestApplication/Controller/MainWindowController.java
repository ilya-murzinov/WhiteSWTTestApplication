package com.TestStack.White.SWTTestApplication.Controller;

import com.TestStack.White.SWTTestApplication.Model.MainWindowModel;
import com.TestStack.White.SWTTestApplication.View.DialogModalWindowView;
import com.TestStack.White.SWTTestApplication.View.MainWindowView;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * Class represents a controller, which links together model and view.
 * View get filled with all data from model here.
 *
 * @author Murzinov Ilya
 */
public class MainWindowController {
	private final MainWindowView view;
	private final MainWindowModel model;
	
	public MainWindowController(final MainWindowModel model, final MainWindowView view) {
		this.view = view;
		this.model = model;
		view.listControlsTab.getCombo().setItems(model.getComboboxItems());
        view.listControlsTab.getEditableCombo().setItems(model.getComboboxItems());
		view.inputControlsTab.getTextBox().setText(model.getTextBoxTest());
        view.listControlsTab.getList().setItems(model.getListItems());
        view.listControlsTab.getChangeItemButtons().addMouseListener(changeItemButtonMouseListener);
        view.getToolBar().addMouseListener(toolBarMouseListener);
        view.inputControlsTab.getTextBox().addModifyListener(textBoxModifyListener);
        view.scenariosTab.getButton().addMouseListener(openDialogButtonMouseListener);
        generateTable(view.dataGridTab.getTable(), model.getDataGridColumnNames(), model.getTableData());
	}

    private void generateTable(Table table, String[] columnNames, String[][] tableItems) {
        TableEditor editor = new TableEditor(table);
        for (String s : columnNames) {
            TableColumn column = new TableColumn(table, SWT.NONE);
            column.setText(s);
        }
        for (String[] s : tableItems) {
            int i = 0;
            TableItem item = new TableItem (table, SWT.NONE);
            for (String s1 : s)
                item.setText(i++, s1);
            //TODO: only 1 combobox appears instead of 3
            Combo combo = new Combo(table, SWT.NONE);
            combo.setText("CCombo");
            combo.add("item 1");
            combo.add("item 2");
            editor.grabHorizontal = true;
            editor.setEditor(combo, item, 3);
        }
        for (int i=0; i<columnNames.length; i++) {
            table.getColumn(i).pack();
        }
    }

    public MouseListener changeItemButtonMouseListener = new MouseAdapter() {
        @Override
        public void mouseDown(MouseEvent e) {
            view.listControlsTab.getList().setItems(model.getChangedListItems());
        }
    };

    public MouseListener toolBarMouseListener = new MouseAdapter() {
        @Override
        public void mouseUp(MouseEvent e) {
            if (e.getSource().equals(view.getToolBar()) && view.getToolBarItem().getSelection()) {
                view.getToolBarItem().setText("Selected");
            }
           else if (e.getSource().equals(view.getToolBar())) {
                view.getToolBarItem().setText("Unselected");
           }
        }
    };

    public ModifyListener textBoxModifyListener = new ModifyListener() {
        @Override
        public void modifyText(ModifyEvent e) {
            model.setTextBoxTest(e.getSource().equals(view.inputControlsTab.getTextBox()) ?
                    view.inputControlsTab.getTextBox().getText(): "null");
        }
    };

    public MouseListener openDialogButtonMouseListener = new MouseAdapter() {
        @Override
        public void mouseDown(MouseEvent e) {
            if (e.getSource().equals(view.scenariosTab.getButton())) {
                DialogModalWindowView view = new DialogModalWindowView();
                DialogModalWindowController controller = new DialogModalWindowController(view);
                view.show();
            }
        }
    };
}