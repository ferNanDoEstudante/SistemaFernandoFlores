/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.FhfClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u1845853
 */
public class FhfControllerCliente extends AbstractTableModel {

    private List lstCliente;

    public void setList(List lstUsuarios) {
        this.lstCliente = lstUsuarios;
    }
    
    public FhfClientes getBean(int rowIndex) {
        return (FhfClientes) lstCliente.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstCliente.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FhfClientes cliente = (FhfClientes) lstCliente.get( rowIndex);
        if ( columnIndex == 0 ){
            return cliente.getFhfIdClientes();
        } else if (columnIndex ==1) {
            return cliente.getFhfNome();        
        } else if (columnIndex ==2) {
            return cliente.getFhfCpf();
        } else if (columnIndex ==3) {
            return cliente.getFhfDataNascimento();
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
            return "CPF";
        } else if ( columnIndex == 3) {
            return "Data de Nascimento";
        } 
        return "";
    }
    
}
