package m2h2.Backoffice.Overzicht;

import javax.swing.table.AbstractTableModel;

public class OverzichtRouteTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID-Order" , "Niet op Voorraad" , "Product-ID" , "Aantal" , "Sectie" , "Product beschrijving"};
    private Object[][] data;

    public OverzichtRouteTableModel(OverzichtRouteController overzichtRouteController) {
        super();
        data = overzichtRouteController.getTableData();
    }
    @Override
    public int getRowCount() {
        return columnNames.length;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    public Class getColumnClass(int column){
        return getValueAt(0, column).getClass();
    }
}
