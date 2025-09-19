/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Vendedor;
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
 * @author eu
 */
public class VendedorDao extends DaoAbstract {


    @Override
    public void insert(Object object) {
        Vendedor vendedor = (Vendedor) object;
        try {
//            Statement stm = cnt.createStatement();
//            stm.executeUpdate("insert into usuarios values("+usuarios.getIdusuarios()+", '"+usuarios.getNome()+"')");
            PreparedStatement pst = cnt.prepareStatement("insert into fhf_vendedor values(?,?,?,?,?,?,?)");
            pst.setInt(1, vendedor.getIdvendedor());
            pst.setString(2, vendedor.getNome());
            pst.setString(3, vendedor.getCpf());
            pst.setString(4, vendedor.getTelefone());
            pst.setInt(5, vendedor.getTurno());
            pst.setString(6, vendedor.getSalario());
            pst.setString(7, vendedor.getEndereco());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(VendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Vendedor vendedor = (Vendedor) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("update fhf_vendedor set fhf_nome=?, fhf_cpf=?, fhf_telefone=?, fhf_turno=?, fhf_salario=?, fhf_endereco=? where fhf_idVendedor=?");
            pst.setInt(7, vendedor.getIdvendedor());
            pst.setString(1, vendedor.getNome());
            pst.setString(2, vendedor.getCpf());
            pst.setString(3, vendedor.getTelefone());
            pst.setInt(4, vendedor.getTurno());
            pst.setString(5, vendedor.getSalario());
            pst.setString(6, vendedor.getEndereco());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(VendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Vendedor vendedor = (Vendedor) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from fhf_vendedor where fhf_idVendedor =?");
            pst.setInt(1, vendedor.getIdvendedor());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(VendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from fhf_vendedor where fhf_idVendedor =?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                Vendedor vendedor = new Vendedor();
                vendedor.setIdvendedor( rs.getInt("fhf_idVendedor") );
                vendedor.setNome(rs.getString("fhf_nome") );
                vendedor.setCpf(rs.getString("fhf_cpf") );
                vendedor.setTelefone(rs.getString("fhf_telefone") );
                vendedor.setTurno(rs.getInt("fhf_turno") );
                vendedor.setSalario(rs.getString("fhf_salario") );
                vendedor.setEndereco(rs.getString("fhf_endereco") );
                return vendedor;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(VendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {
        PreparedStatement pst;
        List lista;
        try {
            pst = cnt.prepareStatement("select * from fhf_vendedor");
            ResultSet rs = pst.executeQuery();
            lista = new ArrayList();
            while (rs.next() == true) {
                Vendedor vendedor = new Vendedor();
                vendedor.setIdvendedor( rs.getInt("fhf_idVendedor") );
                vendedor.setNome(rs.getString("fhf_nome") );
                vendedor.setCpf(rs.getString("fhf_cpf") );
                vendedor.setTelefone(rs.getString("fhf_telefone") );
                vendedor.setTurno(rs.getInt("fhf_turno") );
                vendedor.setSalario(rs.getString("fhf_salario") );
                vendedor.setEndereco(rs.getString("fhf_endereco") );
                lista.add( vendedor );
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        
        System.out.println("executou com sucesso.");
    }

}
