package m2h2.Backoffice.Magazijn;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MagazijnRouteTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID-Order" , "Niet op Voorraad" , "Product-ID" , "Aantal" , "Sectie" , "Product beschrijving"};
    private Object[][] data;

    public MagazijnRouteTableModel(MagazijnRouteController mRouteController){
        super();
        data = mRouteController.getTableData();
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

    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 1:
                return Boolean.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 1;
    }

    @Override
    public void setValueAt(Object aValue, int row, int col) {
        if (col == 1 && aValue instanceof Boolean) {
            data[row][col] = aValue;
            fireTableCellUpdated(row, col);
        }
    }
}
