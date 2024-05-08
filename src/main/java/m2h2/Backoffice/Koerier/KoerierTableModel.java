package m2h2.Backoffice.Koerier;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class KoerierTableModel extends AbstractTableModel {

    private final String[] cols = {"ID-route", "Bus", "Aantal orders", "Regio", "Postcodes", ""};

    private final Object[][] data;

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
        return getValueAt(0, column).getClass();
    }

}
