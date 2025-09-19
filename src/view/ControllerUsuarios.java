/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Usuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u06739637130
 */
public class ControllerUsuarios extends AbstractTableModel {

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
        Usuarios usuarios = (Usuarios) lista.get(rowIndex);
        if (columnIndex == 0) {
            return usuarios.getIdusuarios();
        }
        if (columnIndex == 1) {
            return usuarios.getNome();
        }
        if (columnIndex == 2) {
            return usuarios.getCpf();
        }
        if (columnIndex == 3) {
            return usuarios.getApelido();
        }
        if (columnIndex == 4) {
            return usuarios.getDataNascimento();
        }
        if (columnIndex == 5) {
            return usuarios.getSenha();
        } 
        if (columnIndex == 6){
            return usuarios.getNivel();
        }
        if (columnIndex == 7){
            return usuarios.getAtivo();
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
            return "apelido";
        }
        if (column == 3) {
            return "CPF";
        }else {
            return "";
        }
    }

    
}
