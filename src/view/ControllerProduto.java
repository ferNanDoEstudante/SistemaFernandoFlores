/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u06739637130
 */
public class ControllerProduto extends AbstractTableModel{

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
         Produto produto = (Produto) lista.get(rowIndex);
        if (columnIndex == 0) {
            return produto.getIdproduto();
        }
        if (columnIndex == 1) {
            return produto.getNome();
        }
        if (columnIndex == 2) {
            return produto.getQuantidade();
        }
        if (columnIndex == 3) {
            return produto.getPreco();
        }
        if (columnIndex == 4) {
            return produto.getDescricao();
        }
        if (columnIndex == 5) {
            return produto.getTipo();
        } 
        if (columnIndex == 6){
            return produto.getDataAdicao();
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
            return "quantidade";
        }
        if (column == 3) {
            return "preço";
        }else {
            return "";
        }
    }
    
}
