package com.TestStack.White.SWTTestApplication;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */

import com.TestStack.White.SWTTestApplication.Controller.MainWindowController;
import com.TestStack.White.SWTTestApplication.Model.MainWindowModel;
import com.TestStack.White.SWTTestApplication.View.MainWindowView;
import org.eclipse.swt.events.MouseEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//TODO: separate this class into several specific ones
@RunWith(JUnit4.class)
public class Tests {
    MainWindowModel model = new MainWindowModel();
    MainWindowView view = new MainWindowView();
    MainWindowController controller = new MainWindowController(model, view);
    MouseEvent mouseEventMock = mock(MouseEvent.class);

    @Test
    public void tabCountTest() {
        Field[] fields = view.getClass().getFields();
        int tabCount = 0;
        for (Field f : fields) {
            if (Modifier.isPublic(f.getModifiers()))
                tabCount++;
        }
        assertEquals("Only TabView fields should be public in MainWindowView", 4, tabCount);
    }

    @Test
    public void Test() {

    }

    @Test
    public void textBoxTest() {
        assertEquals(model.getComboboxItems().length, 3);
        assertEquals(model.getTextBoxTest(), view.inputControlsTab.getTextBox().getText());
        view.inputControlsTab.getTextBox().setText("123123asd");
        assertEquals("123123asd", view.inputControlsTab.getTextBox().getText());
        assertEquals("123123asd", model.getTextBoxTest());
    }

    @Test
    public void comboTest() {
        view.listControlsTab.getCombo().select(1);
        assertEquals(1, view.listControlsTab.getCombo().getSelectionIndex());
    }

    @Test
    public void changeItemsTest() {
        assertEquals(model.getListItems(), view.listControlsTab.getList().getItems());
        when(mouseEventMock.getSource()).thenReturn(view.listControlsTab.getChangeItemButtons());
        controller.changeItemButtonMouseListener.mouseDown(mouseEventMock);
        assertEquals(model.getChangedListItems(), view.listControlsTab.getList().getItems());
    }

    @Test
    public void buttonInToolBarTest() {
        assertEquals("Button in toolbar", view.getToolBarItem().getText());
        when(mouseEventMock.getSource()).thenReturn(view.getToolBar());
        view.getToolBarItem().setSelection(true);
        controller.toolBarMouseListener.mouseUp(mouseEventMock);
        assertEquals("Selected", view.getToolBarItem().getText());
        view.getToolBarItem().setSelection(false);
        controller.toolBarMouseListener.mouseUp(mouseEventMock);
        assertEquals("Unselected", view.getToolBarItem().getText());
    }
}
