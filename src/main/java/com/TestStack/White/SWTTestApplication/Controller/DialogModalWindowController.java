package com.TestStack.White.SWTTestApplication.Controller;

import com.TestStack.White.SWTTestApplication.View.DialogModalWindowView;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

/**
 * Created by ilya-murzinov on 18.02.14.
 */
public class DialogModalWindowController {
    DialogModalWindowView view;

    DialogModalWindowController(DialogModalWindowView view) {
        this.view = view;
        view.getCloseButton().addMouseListener(closeButtonMouseListener);
    }

    public MouseListener closeButtonMouseListener = new MouseAdapter() {
        @Override
        public void mouseDown(MouseEvent e) {
            if (e.getSource().equals(view.getCloseButton()))
                view.getDialogShell().dispose();
        }
    };
}
