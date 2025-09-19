/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Vendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ControllerVendas extends AbstractTableModel {

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
        Vendas vendas = (Vendas) lista.get(rowIndex);
        if (columnIndex == 0) {
            return vendas.getIdvendas();
        }
        if (columnIndex == 1) {
            return vendas.getFkclientes();
        }
        if (columnIndex == 2) {
            return vendas.getFkVendedor();
        }
        if (columnIndex == 3) {
            return vendas.getData();
        }
        if (columnIndex == 4) {
            return vendas.getFormaPagamento();
        }
        if (columnIndex == 5) {
            return vendas.getTotal();
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
            return "cliente";
        }
        if (column == 2) {
            return "vendedor";
        }
        if (column == 3) {
            return "data";
        }else {
            return "";
        }
    }

    
}
