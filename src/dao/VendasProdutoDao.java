/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.VendasProduto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class VendasProdutoDao extends DaoAbstract {


    @Override
    public void insert(Object object) {
        VendasProduto vendasProduto = (VendasProduto) object;
        try {
//            Statement stm = cnt.createStatement();
//            stm.executeUpdate("insert into usuarios values("+usuarios.getIdusuarios()+", '"+usuarios.getNome()+"')");
            PreparedStatement pst = cnt.prepareStatement("insert into fhf_vendasroduto values(?,?,?,?,?)");
            pst.setInt(1, vendasProduto.getIdvendasproduto());
            pst.setInt(2, vendasProduto.getQuantidade());
            pst.setInt(3, vendasProduto.getQuantidade());
            pst.setInt(4, vendasProduto.getFkidvendas());
            pst.setInt(5, vendasProduto.getFkidproduto());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(VendasProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        VendasProduto vendasProduto = (VendasProduto) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("update fhf_vendasproduto set fhf_quantidade=?, fhf_data=?, fhf_precoUnitario=?, fhf_fkidVendas=?, fhf_fkidProduto=?, where fhf_idVendasproduto=?");
            pst.setInt(5, vendasProduto.getIdvendasproduto());
            pst.setInt(1, vendasProduto.getQuantidade());
            pst.setInt(2, vendasProduto.getPrecoUnitario());
            pst.setInt(3, vendasProduto.getFkidvendas());
            pst.setInt(4, vendasProduto.getFkidproduto());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(VendasProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        VendasProduto vendasProduto = (VendasProduto) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from fhf_vendasproduto where fhf_idVendasproduto =?");
            pst.setInt(1, vendasProduto.getIdvendasproduto());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(VendasProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from fhf_vendasproduto where fhf_idVendasproduto =?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                VendasProduto vendasProduto = new VendasProduto();
                pst.setInt(5, vendasProduto.getIdvendasproduto());
                pst.setInt(1, vendasProduto.getQuantidade());
                pst.setInt(2, vendasProduto.getPrecoUnitario());
                pst.setInt(3, vendasProduto.getFkidvendas());
                pst.setInt(4, vendasProduto.getFkidproduto());
                pst.executeUpdate();
                return vendasProduto;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(VendasProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        
        System.out.println("executou com sucesso.");
    }

}
