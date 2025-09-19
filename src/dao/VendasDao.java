/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Vendas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class VendasDao extends DaoAbstract {

    @Override
    public void insert(Object object) {
        Vendas vendas = (Vendas) object;
        try {
//            Statement stm = cnt.createStatement();
//            stm.executeUpdate("insert into usuarios values("+usuarios.getIdusuarios()+", '"+usuarios.getNome()+"')");
            PreparedStatement pst = cnt.prepareStatement("insert into fhf_vendas values(?,?,?,?,?,?)");
            pst.setInt(1, vendas.getIdvendas());
            pst.setString(2, null);
            pst.setString(3, null);
            java.sql.Date data = new java.sql.Date(vendas.getData().getTime());
            pst.setDate(4, (data));
            pst.setString(5, vendas.getFormaPagamento());
            pst.setString(6, vendas.getTotal());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(VendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Vendas vendas = (Vendas) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("update fhf_vendas set fhf_fkClientes=?, fhf_fkVendedor=?, fhf_data=?, fhf_formaPagamento=?, fhf_total=? where fhf_idVendas=?");
            pst.setInt(6, vendas.getIdvendas());
            pst.setString(1, null);
            pst.setString(2, null);
            java.sql.Date data = new java.sql.Date(vendas.getData().getTime());
            pst.setDate(3, (data));
            pst.setString(4, vendas.getFormaPagamento());
            pst.setString(5, vendas.getTotal());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Vendas vendas = (Vendas) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from fhf_vendas where fhf_idVendas =?");
            pst.setInt(1, vendas.getIdvendas());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(VendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from fhf_vendas where fhf_idVendas =?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                Vendas vendas = new Vendas();
                vendas.setIdvendas(rs.getInt("fhf_idVendas"));
                vendas.setFkclientes(rs.getInt("fhf_fkClientes"));
                vendas.setFkVendedor(rs.getInt("fhf_fkVendedor"));
                vendas.setData(rs.getDate("fhf_data"));
                vendas.setFormaPagamento(rs.getString("fhf_formaPagamento"));
                vendas.setTotal(rs.getString("fhf_total"));
                return vendas;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(VendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {
        PreparedStatement pst;
        List lista;
        try {
            pst = cnt.prepareStatement("select * from fhf_vendas");
            ResultSet rs = pst.executeQuery();
            lista = new ArrayList();
            while (rs.next() == true) {
                Vendas vendas = new Vendas();
                vendas.setIdvendas(rs.getInt("fhf_idVendas"));
                vendas.setFkclientes(rs.getInt("fhf_fkClientes"));
                vendas.setFkVendedor(rs.getInt("fhf_fkVendedor"));
                vendas.setData(rs.getDate("fhf_data"));
                vendas.setFormaPagamento(rs.getString("fhf_formaPagamento"));
                vendas.setTotal(rs.getString("fhf_total"));
                lista.add( vendas );
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(VendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        
        System.out.println("executou com sucesso.");
    }

}
