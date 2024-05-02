package m2h2.Backoffice.Koerier;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class KoerierTableModel extends AbstractTableModel {

    private String[] cols = {"ID-route", "Bus", "Aantal orders", "Postcodes", "Status"};

    private Object[][] data;

    public KoerierTableModel(KoerierController kController, String status){
        super();
        data = kController.getTableData(status);
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return  cols.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }


}
