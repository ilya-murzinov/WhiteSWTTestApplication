package com.TestStack.White.SWTTestApplication.Tests;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */
import com.TestStack.White.SWTTestApplication.Controller.MainWindowController;
import com.TestStack.White.SWTTestApplication.Model.MainWindowModel;
import com.TestStack.White.SWTTestApplication.View.MainWindowView;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Tests {
    MainWindowModel model = new MainWindowModel();
    MainWindowView view = new MainWindowView();
    MainWindowController controller = new MainWindowController(model, view);

    @Test
    public void test() {
        Assert.assertEquals(model.comboboxItems.length, 3);
        Assert.assertEquals("123", view.inputControlsTab.getTextBoxText());
        view.inputControlsTab.setTextBoxText("123123asd");
        Assert.assertEquals("123123asd", view.inputControlsTab.getTextBoxText());
    }

    @Test
    public void test2() {
        view.listControlsTab.selectItemCombo(1);
        Assert.assertEquals(1, view.listControlsTab.getSelectionIndexCombo());
    }
}
