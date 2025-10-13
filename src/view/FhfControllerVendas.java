/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.FhfVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u1845853
 */
public class FhfControllerVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
    }
    
    public FhfVendas getBean(int rowIndex) {
        return (FhfVendas) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FhfVendas vendas = (FhfVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendas.getFhfIdVendas();
        } else if (columnIndex ==1) {
            return vendas.getFhfClientes();        
        } else if (columnIndex ==2) {
            return vendas.getFhfVendedor();
        } else if (columnIndex ==3) {
            return vendas.getFhfData();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Cliente";         
        } else if ( columnIndex == 2) {
            return "Vendedor";
        } else if ( columnIndex == 3) {
            return "Data";
        } 
        return "";
    }
    
}
