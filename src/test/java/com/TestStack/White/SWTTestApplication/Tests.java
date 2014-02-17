package com.TestStack.White.SWTTestApplication;

import com.TestStack.White.SWTTestApplication.Controller.MainWindowController;
import com.TestStack.White.SWTTestApplication.Model.MainWindowModel;
import com.TestStack.White.SWTTestApplication.View.MainWindowView;
import org.eclipse.swt.events.MouseEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Murzinov Ilya
 * @since 1.7.0
 *
 * Class with tests
 */
//TODO: separate this class into several specific ones
@RunWith(JUnit4.class)
public class Tests {
    MainWindowModel model = new MainWindowModel();
    MainWindowView view = new MainWindowView();
    MainWindowController controller = new MainWindowController(model, view);
    /**
     * Mock used to simulate mouse event on widgets
     */
    MouseEvent mouseEventMock = mock(MouseEvent.class);

    @Test
    /**
     * Checks count of public fields in MainWindowView
     */
    public void tabCountTest() {
        Field[] fields = view.getClass().getFields();
        int tabCount = 0;
        for (Field f : fields) {
            if (Modifier.isPublic(f.getModifiers()))
                tabCount++;
        }
        assertEquals("Only TabView fields should be public in MainWindowView", 5, tabCount);
    }

    @Test
    /**
     * Checks that TabView classes have only private fields
     */
    public void allFieldsInTabViewsShouldBePrivateTest() {
        Field[] fields = view.getClass().getFields();
        for (Field f : fields) {
            System.out.println(f.getType().getName());
            Field[] fields1 = f.getType().getDeclaredFields();
            for (Field f1 : fields1) {
                assertEquals(f1.getName() + " in class " + f.getType().toString() + " is not private",
                        Modifier.isPrivate(f1.getModifiers()), true);
            }
        }
    }

    @Test
    /**
     *
     */
    public void textBoxTest() {
        assertEquals(model.getComboboxItems().length, 3);
        assertEquals(model.getTextBoxTest(), view.inputControlsTab.getTextBox().getText());
        view.inputControlsTab.getTextBox().setText("123123asd");
        assertEquals("123123asd", view.inputControlsTab.getTextBox().getText());

        //When text in the TextBox changes, corresponding property of MainWindowModel should change too
        assertEquals("123123asd", model.getTextBoxTest());
    }

    @Test
    public void comboTest() {
        view.listControlsTab.getCombo().select(1);
        assertEquals(1, view.listControlsTab.getCombo().getSelectionIndex());
    }

    @Test
    /**
     * Checks that changeItemButton changes items in list
     */
    public void changeItemsTest() {
        assertArrayEquals(model.getListItems(), view.listControlsTab.getList().getItems());
        when(mouseEventMock.getSource()).thenReturn(view.listControlsTab.getChangeItemButtons());
        controller.changeItemButtonMouseListener.mouseDown(mouseEventMock);
        assertArrayEquals(model.getChangedListItems(), view.listControlsTab.getList().getItems());
    }

    @Test
    /**
     * Checks that test of tool bar button corresponds to it's state
     */
    public void buttonInToolBarTest() {
        assertEquals("Button in toolbar", view.getToolBarItem().getText());
        when(mouseEventMock.getSource()).thenReturn(view.getToolBar());

        // Selection of this button should be set manually,
        // because mouse event doesn't actually take place
        view.getToolBarItem().setSelection(true);
        controller.toolBarMouseListener.mouseUp(mouseEventMock);

        assertEquals("Selected", view.getToolBarItem().getText());
        view.getToolBarItem().setSelection(false);
        controller.toolBarMouseListener.mouseUp(mouseEventMock);
        assertEquals("Unselected", view.getToolBarItem().getText());
    }

    @Test
    public void modalWindowTest() {
        when(mouseEventMock.getSource()).thenReturn(view.scenariosTab.getButton());
        //TODO: check that window opened
        //controller.openDialogButtonMouseListener.mouseDown(mouseEventMock);
    }
}
