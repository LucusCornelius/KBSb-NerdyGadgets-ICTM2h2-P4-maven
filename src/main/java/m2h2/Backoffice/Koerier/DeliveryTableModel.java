package m2h2.Backoffice.Koerier;

import javax.swing.table.AbstractTableModel;

public class DeliveryTableModel extends AbstractTableModel {

    private String[] cols = {"ID-Route", "Adres", "Postcode", "Aantal Pakketjes", "Niet Bezorgd"};

    private Object[][] data;

    public DeliveryTableModel(DeliveryController dController){
        super();
        data = dController.getTableData();
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
