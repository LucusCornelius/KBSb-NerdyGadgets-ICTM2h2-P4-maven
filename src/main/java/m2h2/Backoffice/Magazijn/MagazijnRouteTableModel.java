package m2h2.Backoffice.Magazijn;

import javax.swing.table.AbstractTableModel;

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
    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }
}
