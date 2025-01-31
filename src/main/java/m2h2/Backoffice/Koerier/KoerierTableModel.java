package m2h2.Backoffice.Koerier;

import m2h2.Backoffice.Components.Route;

import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class KoerierTableModel extends AbstractTableModel {

    private String[] cols = {"ID-route", "Bus", "Aantal orders", "Regio", "Postcodes", ""};

    private Object[][] data;

    public KoerierTableModel(KoerierController kController, String status){
        super();
        data = kController.getTableData(status);
    }

    public int getColumnCount() {
        return cols.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return cols[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int column) {
        try {
            return getValueAt(0, column).getClass();
        } catch (NullPointerException e){
            return String.class;
        }
    }

}
