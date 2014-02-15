package com.TestStack.White.SWTTestApplication.Controller;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */
import com.TestStack.White.SWTTestApplication.View.*;
import com.TestStack.White.SWTTestApplication.Model.*;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

public class MainWindowController {
	private final MainWindowView view;
	private final MainWindowModel model;
	
	public MainWindowController(final MainWindowModel model, final MainWindowView view) {
		this.view = view;
		this.model = model;
		view.listControlsTab.setComboboxItems(model.getComboboxItems());
		view.inputControlsTab.setTextBoxText("123");
        view.listControlsTab.setListItems(model.getListItems());
        view.listControlsTab.setChangeItemButtonMouseListener(changeItemButtonMouseListener);
        view.setToolBarMouseListener(toolBarMouseListener);
	}

    private MouseListener changeItemButtonMouseListener = new MouseListener() {
        @Override
        public void mouseDoubleClick(MouseEvent e) {

        }

        @Override
        public void mouseDown(MouseEvent e) {
            view.listControlsTab.setListItems(model.getChangedListItems());
        }

        @Override
        public void mouseUp(MouseEvent e) {

        }
    };

    private MouseListener toolBarMouseListener = new MouseListener() {
        @Override
        public void mouseDoubleClick(MouseEvent e) {

        }

        @Override
        public void mouseDown(MouseEvent e) {

        }

        @Override
        public void mouseUp(MouseEvent e) {

        }
    };
}