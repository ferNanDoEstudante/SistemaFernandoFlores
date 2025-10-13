/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.FhfProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u1845853
 */
public class FhfControllerProduto extends AbstractTableModel {

    private List lstProduto;

    public void setList(List lstProduto) {
        this.lstProduto = lstProduto;
    }
    
    public FhfProduto getBean(int rowIndex) {
        return (FhfProduto) lstProduto.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstProduto.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FhfProduto produto = (FhfProduto) lstProduto.get( rowIndex);
        if ( columnIndex == 0 ){
            return produto.getFhfIdProduto();
        } else if (columnIndex ==1) {
            return produto.getFhfNome();        
        } else if (columnIndex ==2) {
            return produto.getFhfQuantidade();
        } else if (columnIndex ==3) {
            return produto.getFhfPreco();
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
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Preço";
        } 
        return "";
    }
    
}
