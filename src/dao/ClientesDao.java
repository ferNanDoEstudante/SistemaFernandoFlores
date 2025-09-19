/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Clientes;
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
public class ClientesDao extends DaoAbstract {


    @Override
    public void insert(Object object) {
        Clientes clientes = (Clientes) object;
        try {
//            Statement stm = cnt.createStatement();
//            stm.executeUpdate("insert into clientes values("+clientes.getIdclientes()+", '"+clientes.getNome()+"')");
            PreparedStatement pst = cnt.prepareStatement("insert into fhf_clientes values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, clientes.getIdclientes());
            pst.setString(2, clientes.getNome());
            pst.setString(3, clientes.getCpf());
            pst.setString(4, clientes.getSexo());
            pst.setString(5, clientes.getRg());
            pst.setString(6, clientes.getEmail());
            java.sql.Date dataNasc = new java.sql.Date(clientes.getDataNascimento().getTime());
            pst.setDate(7, (dataNasc));
            pst.setString(8, clientes.getCep());
            pst.setString(9, clientes.getEndereco());
            pst.setString(10, clientes.getBairro());
            pst.setString(11, clientes.getCidade());
            pst.setString(12, clientes.getEstado());
            pst.setString(13, clientes.getCelular());
            java.sql.Date dataCadas = new java.sql.Date(clientes.getDataCadastro().getTime());
            pst.setDate(14, (dataCadas));
            pst.setString(15, clientes.getAtivo());//ativo
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Clientes clientes = (Clientes) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("update fhf_clientes set fhf_nome=?, fhf_cpf=?, fhf_sexo=?, fhf_rg=?, fhf_email=?, fhf_dataNascimento=?, fhf_cep =?, fhf_endereco=?, fhf_bairro, fhf_cidade=?, fhf_estado=?, fhf_celular=?, fhf_dataCadastro=?, fhf_ativo=?  where fhf_idClientes=?");
            pst.setInt(15, clientes.getIdclientes());
            pst.setString(1, clientes.getNome());
            pst.setString(2, clientes.getCpf());
            pst.setString(3, clientes.getSexo());
            pst.setString(4, clientes.getRg());
            pst.setString(5, clientes.getEmail());
            java.sql.Date dataNasc = new java.sql.Date(clientes.getDataNascimento().getTime());
            pst.setDate(6, (dataNasc));
            pst.setString(7, clientes.getCep());
            pst.setString(8, clientes.getEndereco());
            pst.setString(9, clientes.getBairro());
            pst.setString(10, clientes.getCidade());
            pst.setString(11, clientes.getEstado());
            pst.setString(12, clientes.getCelular());
            java.sql.Date dataCadas = new java.sql.Date(clientes.getDataCadastro().getTime());
            pst.setDate(13, (dataCadas));
            pst.setString(14, clientes.getAtivo());//ativo
            pst.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(ClientesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Clientes clientes = (Clientes) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from fhf_clientes where fhf_idclientes =?");
            pst.setInt(1, clientes.getIdclientes());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from fhf_clientes where fhf_idClientes =?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                Clientes clientes = new Clientes();
                clientes.setIdclientes( rs.getInt("fhf_idClientes") );
                clientes.setNome(rs.getString("fhf_nome") );
                clientes.setApelido(rs.getString("fhf_cpf") );
                clientes.setCpf(rs.getString("fhf_sexo") );
                clientes.setRg(rs.getString("fhf_rg") );
                clientes.setEmail(rs.getString("fhf_email") );
                clientes.setDataNascimento(rs.getDate("fhf_dataNascimento") );
                clientes.setCep(rs.getString("fhf_cep") );
                clientes.setEndereco(rs.getString("fhf_endereco") );
                clientes.setBairro(rs.getString("fhf_bairro") );
                clientes.setCidade(rs.getString("fhf_cidade") );
                clientes.setEstado(rs.getString("fhf_estado") );
                clientes.setCelular(rs.getString("fhf_celular") );
                clientes.setDataCadastro(rs.getDate("fhf_dataCadastro") );
                clientes.setAtivo(rs.getString("fhf_ativo") );
                return clientes;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {
        PreparedStatement pst;
        List lista;
        try {
            pst = cnt.prepareStatement("select * from fhf_clientes");
            ResultSet rs = pst.executeQuery();
            lista = new ArrayList();
            while (rs.next() == true) {
                Clientes clientes = new Clientes();
                clientes.setIdclientes( rs.getInt("fhf_idClientes") );
                clientes.setNome(rs.getString("fhf_nome") );
                clientes.setCpf(rs.getString("fhf_cpf") );
                clientes.setSexo(rs.getString("fhf_sexo") );
                clientes.setRg(rs.getString("fhf_rg") );
                clientes.setEmail(rs.getString("fhf_email") );
                clientes.setDataNascimento(rs.getDate("fhf_dataNascimento") );
                clientes.setCep(rs.getString("fhf_cep") );
                clientes.setEndereco(rs.getString("fhf_endereco") );
                clientes.setBairro(rs.getString("fhf_bairro") );
                clientes.setCidade(rs.getString("fhf_cidade") );
                clientes.setEstado(rs.getString("fhf_estado") );
                clientes.setCelular(rs.getString("fhf_celular") );
                clientes.setDataCadastro(rs.getDate("fhf_dataCadastro") );
                clientes.setAtivo(rs.getString("fhf_ativo") );
                lista.add( clientes );
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        
        System.out.println("executou com sucesso.");
    }

}
