package m2h2.Backoffice.Magazijn;

import m2h2.Backoffice.Components.*;

import javax.swing.*;
import javax.swing.table.*;

public class MagazijnTableModel extends AbstractTableModel {
    private String[] columnNames;
    private Object[][] data;

    public MagazijnTableModel(Object[][] tableData){
        super();
        String [] tableColums = {"ID-Route" , "Bus" , "Aantal orders" , "Postcodes" , "Status"};
        columnNames = tableColums;
        data = tableData;
    }
    public MagazijnTableModel(Route route){
        super();
        String [] tableColums = {"ID-Route" , "Bus" , "Aantal orders" , "Postcodes"};
        columnNames = tableColums;
        data = route.getDescriptionTableData();
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
            System.out.println("### null pointer exception - getcolumnclass magazijntablemodel ###");
            return String.class;
        }
     }
}
