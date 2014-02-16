package com.TestStack.White.SWTTestApplication.Controller;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */
import com.TestStack.White.SWTTestApplication.Model.MainWindowModel;
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
		view.inputControlsTab.getTextBox().setText("123");
        view.listControlsTab.getList().setItems(model.getListItems());
        view.listControlsTab.getChangeItemButtons().addMouseListener(changeItemButtonMouseListener);
        view.setToolBarMouseListener(toolBarMouseListener);
	}

    public MouseListener changeItemButtonMouseListener = new MouseAdapter() {
        @Override
        public void mouseDown(MouseEvent e) {
            view.listControlsTab.getList().setItems(model.getChangedListItems());
        }
    };

    public MouseListener toolBarMouseListener = new MouseAdapter() {
        @Override
        public void mouseDown(MouseEvent e) {
            if (!view.getToolBarItem().getText().equals("Selected")) view.getToolBarItem().setText("Selected");
            else view.getToolBarItem().setText("Unselected");
        }
    };
}