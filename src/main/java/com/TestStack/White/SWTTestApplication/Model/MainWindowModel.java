package com.TestStack.White.SWTTestApplication.Model;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */
public class MainWindowModel {
	private String[] comboboxItems;
    private String[] listItems;
    private String[] changedListItems;
    private String textBoxTest;
    private String[] dataGridColumnNames;
    private String[] dataGridRow1Values;
    private String[] dataGridRow2Values;
    private String[] dataGridRow3Values;
    private String[][] tableData;

    public String[] getComboboxItems() {
        return comboboxItems;
    }

    public String[] getListItems() {
        return listItems;
    }

    public String[] getChangedListItems() {
        return changedListItems;
    }

    public String getTextBoxTest() {
        return textBoxTest;
    }

    public void setTextBoxTest(String textBoxTest) {
        this.textBoxTest = textBoxTest;
    }

    public String[] getDataGridColumnNames() {
        return dataGridColumnNames;
    }

    public String[][] getTableData() {
        return tableData;
    }

    public MainWindowModel() {
		comboboxItems = new String[] {"Item", "Item2", "Item3"};
        listItems = new String[] {"Item", "Item2", "Item3", "Item4", "Item5"};
        changedListItems = new String[] {"Item6", "Item7", "Item8", "Item4", "Item5"};
        textBoxTest = "123";
        dataGridColumnNames = new String[] {"Id", "Item", "Description", "Combobox"};
        dataGridRow1Values = new String[] {"1", "Item 1", "Simple Item 1"};
        dataGridRow2Values = new String[] {"2", "Item 2"};
        dataGridRow3Values = new String[] {"3", "Item 3"};
        tableData = new String[][] {dataGridRow1Values, dataGridRow2Values, dataGridRow3Values};
	}
}
