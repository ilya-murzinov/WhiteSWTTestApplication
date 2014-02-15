package com.TestStack.White.SWTTestApplication.Model;

/**
 * Created by Murzinov Ilya on 2/14/14.
 */
public class MainWindowModel {
	private String[] comboboxItems;
    private String[] listItems;
    private String[] changedListItems;


    public String[] getComboboxItems() {
        return comboboxItems;
    }

    public String[] getListItems() {
        return listItems;
    }

    public String[] getChangedListItems() {
        return changedListItems;
    }
	
	public MainWindowModel() {
		comboboxItems = new String[] {"Item", "Item2", "Item3"};
        listItems = new String[] {"Item", "Item2", "Item3", "Item4", "Item5"};
        changedListItems = new String[] {"Item6", "Item7", "Item8", "Item4", "Item5"};
	}
}
