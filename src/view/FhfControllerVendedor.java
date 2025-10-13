/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.FhfVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u1845853
 */
public class FhfControllerVendedor extends AbstractTableModel {

    private List lstVendedor;

    public void setList(List lstVendedor) {
        this.lstVendedor = lstVendedor;
    }
    
    public FhfVendedor getBean(int rowIndex) {
        return (FhfVendedor) lstVendedor.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendedor.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FhfVendedor usuarios = (FhfVendedor) lstVendedor.get( rowIndex);
        if ( columnIndex == 0 ){
            return usuarios.getFhfIdVendedor();
        } else if (columnIndex ==1) {
            return usuarios.getFhfNome();        
        } else if (columnIndex ==2) {
            return usuarios.getFhfTelefone();
        } else if (columnIndex ==3) {
            return usuarios.getFhfTurno();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Telefone";
        } else if ( columnIndex == 3) {
            return "Turno";
        } 
        return "";
    }
    
}
