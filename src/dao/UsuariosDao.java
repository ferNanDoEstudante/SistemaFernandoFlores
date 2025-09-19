/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Usuarios;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class UsuariosDao extends DaoAbstract {



    public UsuariosDao() {

    }
   
    public boolean autenticar(String apelido, String senha) {
        try {
            PreparedStatement pst;
            pst = cnt.prepareStatement("select * from fhf_usuarios where fhf_apelido=? and fhf_senha=?");
            pst.setString(1, apelido);
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();
            if(rs.next()==true) return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
     
    @Override
    public void insert(Object object) {
        Usuarios usuarios = (Usuarios) object;
        try {
//            Statement stm = cnt.createStatement();
//            stm.executeUpdate("insert into usuarios values("+usuarios.getIdusuarios()+", '"+usuarios.getNome()+"')");
            PreparedStatement pst = cnt.prepareStatement("insert into fhf_usuarios values(?,?,?,?,?,?,?,?)");
            pst.setInt(1, usuarios.getIdusuarios());
            pst.setString(2, usuarios.getNome());
            pst.setString(3, usuarios.getApelido());
            pst.setString(4, usuarios.getCpf());
            java.sql.Date dataNasc = new java.sql.Date(usuarios.getDataNascimento().getTime());
            pst.setDate(5, (dataNasc));
            pst.setString(6, usuarios.getSenha());//senha
            pst.setInt(7, usuarios.getNivel());//nivel
            pst.setString(8, usuarios.getAtivo());//ativo
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Usuarios usuarios = (Usuarios) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("update fhf_usuarios set fhf_nome=?, fhf_apelido=?, fhf_cpf=?, fhf_dataNascimento=?, fhf_senha=?, fhf_nivel=?, fhf_ativo =? where fhf_idUsuarios=?");
            pst.setInt(8, usuarios.getIdusuarios());
            pst.setString(1, usuarios.getNome());
            pst.setString(2, usuarios.getApelido());
            pst.setString(3, usuarios.getCpf());
            java.sql.Date dataNasc = new java.sql.Date(usuarios.getDataNascimento().getTime());
            pst.setDate(4, (dataNasc));
            pst.setString(5, usuarios.getSenha());//senha
            pst.setInt(6, usuarios.getNivel());
            pst.setString(7, usuarios.getAtivo());//ativo
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Usuarios usuarios = (Usuarios) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from fhf_usuarios where fhf_idUsuarios =?");
            pst.setInt(1, usuarios.getIdusuarios());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from fhf_usuarios where fhf_idUsuarios =?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                Usuarios usuarios = new Usuarios();
                usuarios.setIdusuarios( rs.getInt("fhf_idUsuarios") );
                usuarios.setNome(rs.getString("fhf_nome") );
                usuarios.setApelido(rs.getString("fhf_apelido") );
                usuarios.setCpf(rs.getString("fhf_cpf") );
                usuarios.setDataNascimento(rs.getDate("fhf_dataNascimento") );
                usuarios.setSenha(rs.getString("fhf_senha") );
                usuarios.setNivel(rs.getInt("fhf_nivel") );
                usuarios.setAtivo(rs.getString("fhf_ativo") );
                return usuarios;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {
        PreparedStatement pst;
        List lista;
        try {
            pst = cnt.prepareStatement("select * from fhf_usuarios");
            ResultSet rs = pst.executeQuery();
            lista = new ArrayList();
            while (rs.next() == true) {
                Usuarios usuarios = new Usuarios();
                usuarios.setIdusuarios( rs.getInt("fhf_idUsuarios") );
                usuarios.setNome(rs.getString("fhf_nome") );
                usuarios.setApelido(rs.getString("fhf_apelido") );
                usuarios.setCpf(rs.getString("fhf_cpf") );
                usuarios.setDataNascimento(rs.getDate("fhf_dataNascimento") );
                usuarios.setSenha(rs.getString("fhf_senha") );
                usuarios.setNivel(rs.getInt("fhf_nivel") );
                usuarios.setAtivo(rs.getString("fhf_ativo") );
                lista.add( usuarios );
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
