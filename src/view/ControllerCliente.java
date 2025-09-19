/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Clientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ControllerCliente extends AbstractTableModel{

    List lista;
    
    public void setLista(List lista){
        this.lista = lista;
    }
    
    public Object getBean(int rowIndex){
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
        Clientes clientes = (Clientes) lista.get(rowIndex);
        if (columnIndex == 0) {
            return clientes.getIdclientes();
        }
        if (columnIndex == 1) {
            return clientes.getNome();
        }
        if (columnIndex == 2) {
            return clientes.getCpf();
        }
        if (columnIndex == 3) {
            return clientes.getEmail();
        }
        if (columnIndex == 4) {
            return clientes.getRg();
        } 
        if (columnIndex == 5) {
            return clientes.getSexo();
        } 
        if (columnIndex == 6){
            return clientes.getDataNascimento();
        }
        if (columnIndex == 7){
            return clientes.getCep();
        }
        if (columnIndex == 8){
            return clientes.getEndereco();
        }
        if (columnIndex == 9){
            return clientes.getBairro();
        }
        if (columnIndex == 10){
            return clientes.getCidade();
        }
        if (columnIndex == 11){
            return clientes.getEstado();
        }
        if (columnIndex == 12){
            return clientes.getCelular();
        }
        if (columnIndex == 13){
            return clientes.getDataCadastro();
        }
        if (columnIndex == 14){
            return clientes.getAtivo();
        }else {
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
            return "email";
        }else {
            return "";
        }
    }
    
}
