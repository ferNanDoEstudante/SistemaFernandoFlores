/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.FhfVendasproduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u1845853
 */
public class FhfControllerVendasProdutos extends AbstractTableModel {

    private List lstVenProd;

    public void setList(List lstVenProd) {
        this.lstVenProd = lstVenProd;
    }
    
    public FhfVendasproduto getBean(int rowIndex) {
        return (FhfVendasproduto) lstVenProd.get(rowIndex);
    }

    public void addBean(FhfVendasproduto vendasProduto){
        this.lstVenProd.add(vendasProduto);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex){
        this.lstVenProd.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstVenProd.size();
                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FhfVendasproduto venProd = (FhfVendasproduto) lstVenProd.get( rowIndex);
        if ( columnIndex == 0 ){
            return venProd.getFhfProduto().getFhfIdProduto();
        } else if (columnIndex ==1) {
            return venProd.getFhfProduto().getFhfNome();
        } else if (columnIndex ==2) {
            return venProd.getFhfQuantidade();
        } else if (columnIndex ==3) {
            return venProd.getFhfPrecoUnitario();
        } else if (columnIndex ==4) {
            return venProd.getFhfQuantidade() * venProd.getFhfPrecoUnitario();
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
            return "Valor Unitário";
        } else if ( columnIndex == 4) {
            return "Total";
        } 
        return "";
    }
    
}
