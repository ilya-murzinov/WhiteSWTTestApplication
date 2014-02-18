package com.TestStack.White.SWTTestApplication.Controller;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */

import com.TestStack.White.SWTTestApplication.Model.MainWindowModel;
import com.TestStack.White.SWTTestApplication.View.DialogModalWindowView;
import com.TestStack.White.SWTTestApplication.View.MainWindowView;
import org.eclipse.swt.events.*;

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