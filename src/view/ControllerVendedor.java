/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Vendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fhenr
 */
public class ControllerVendedor extends AbstractTableModel{

    List lista;

    public void setLista(List lista) {
        this.lista = lista; 
    }

    public Object getBean(int rowIndex) {
        return lista.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vendedor vendedor = (Vendedor) lista.get(rowIndex);
        if (columnIndex == 0) {
            return vendedor.getIdvendedor();
        }
        if (columnIndex == 1) {
            return vendedor.getNome();  
        }
        if (columnIndex == 2) {
            return vendedor.getCpf();
        }
        if (columnIndex == 3) {
            return vendedor.getTelefone();
        }
        if (columnIndex == 4) {
            return vendedor.getTurno();
        }
        if (columnIndex == 5) {
            return vendedor.getSalario();
        } 
        if (columnIndex == 6){
            return vendedor.getEndereco();
        }
        else {
            return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "codigo";
        }
        if (column == 1) {
            return "nome";
        }
        if (column == 2) {
            return "CPF";
        }
        if (column == 3) {
            return "telefone";
        }else {
            return "";
        }
    }

    
}
