package com.TestStack.White.SWTTestApplication.Tests;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */

import com.TestStack.White.SWTTestApplication.Controller.MainWindowController;
import com.TestStack.White.SWTTestApplication.Model.MainWindowModel;
import com.TestStack.White.SWTTestApplication.View.MainWindowView;
import org.eclipse.swt.events.MouseEvent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class Tests {
    MainWindowModel model = new MainWindowModel();
    MainWindowView view = new MainWindowView();
    MainWindowController controller = new MainWindowController(model, view);
    MouseEvent mouseEventMock = mock(MouseEvent.class);

    @Test
    public void textBoxTest() {
        Assert.assertEquals(model.getComboboxItems().length, 3);
        Assert.assertEquals("123", view.inputControlsTab.getTextBox().getText());
        view.inputControlsTab.getTextBox().setText("123123asd");
        Assert.assertEquals("123123asd", view.inputControlsTab.getTextBox().getText());
    }

    @Test
    public void comboTest() {
        view.listControlsTab.getCombo().select(1);
        Assert.assertEquals(1, view.listControlsTab.getCombo().getSelectionIndex());
    }

    @Test
    public void changeItemsTest() {
        Assert.assertEquals(model.getListItems(), view.listControlsTab.getList().getItems());
        when(mouseEventMock.getSource()).thenReturn(view.listControlsTab.getChangeItemButtons());
        controller.changeItemButtonMouseListener.mouseDown(mouseEventMock);
        Assert.assertEquals(model.getChangedListItems(), view.listControlsTab.getList().getItems());
    }

    @Test
    public void buttonInToolBarTest() {
        Assert.assertEquals("Button in toolbar", view.getToolBarItem().getText());
        when(mouseEventMock.getSource()).thenReturn(view.getToolBarItem());
        controller.toolBarMouseListener.mouseDown(mouseEventMock);
        Assert.assertEquals("Selected", view.getToolBarItem().getText());
        controller.toolBarMouseListener.mouseDown(mouseEventMock);
        Assert.assertEquals("Unselected", view.getToolBarItem().getText());
    }
}
