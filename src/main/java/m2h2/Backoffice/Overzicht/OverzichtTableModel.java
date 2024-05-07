package m2h2.Backoffice.Overzicht;

import m2h2.Backoffice.Magazijn.MagazijnController;

import javax.swing.table.AbstractTableModel;

public class OverzichtTableModel extends AbstractTableModel {
    private String[] columnNames ;
    private Object[][] data;

    public OverzichtTableModel(String[] columnNames, Object[][] data){
        super();
        this.data = data;
        this.columnNames = columnNames;
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
