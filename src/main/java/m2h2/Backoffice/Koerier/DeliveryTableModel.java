package m2h2.Backoffice.Koerier;

import javax.swing.table.AbstractTableModel;

public class DeliveryTableModel extends AbstractTableModel {

    private String[] cols = {"Route-ID", "Bezorgadres", "Postcode", "Aantal pakketten per klant", "Afgeleverd"};

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
    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 4:
                return Boolean.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 4;
    }

    @Override
    public void setValueAt(Object aValue, int row, int col) {
        if (col == 4 && aValue instanceof Boolean) {
            data[row][col] = aValue;
            fireTableCellUpdated(row, col);
        }
    }
}
