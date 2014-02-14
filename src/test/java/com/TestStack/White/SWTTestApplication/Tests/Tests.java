/**
 * Created by Murzinov Ilya on 2/14/14.
 */
package test.java.com.TestStack.White.SWTTestApplication.Tests;

import main.java.com.TestStack.White.SWTTestApplication.Model.MainWindowModel;
import main.java.com.TestStack.White.SWTTestApplication.View.MainWindowView;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Tests {
    @Test
    public void Test() {
        MainWindowModel model = new MainWindowModel();
        MainWindowView view = new MainWindowView();
        Assert.assertEquals(model.comboboxItems.length, 3);
        Assert.assertEquals(view.inputControlsTab.getTextBox(),
                "");
        view.inputControlsTab.setTextBox("123123asd");
        Assert.assertEquals(view.inputControlsTab.getTextBox(),
                "123123asd");
    }
}
