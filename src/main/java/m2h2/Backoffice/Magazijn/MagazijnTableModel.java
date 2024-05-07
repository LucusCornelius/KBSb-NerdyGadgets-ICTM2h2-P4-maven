package m2h2.Backoffice.Magazijn;

import javax.swing.*;
import javax.swing.table.*;

public class MagazijnTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID-Route" , "Bus" , "Aantal orders" , "Postcodes" , "Status"};
    private Object[][] data;

    public MagazijnTableModel(MagazijnController mController, String status){
        super();
        data = mController.getTableData(status);
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
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
