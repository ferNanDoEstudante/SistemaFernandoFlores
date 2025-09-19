/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Produto;
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
public class ProdutoDao extends DaoAbstract {


    @Override
    public void insert(Object object) {
        Produto produto = (Produto) object;
        try {
//            Statement stm = cnt.createStatement();
//            stm.executeUpdate("insert into Produto values("+Produto.getIdProduto()+", '"+Produto.getNome()+"')");
            PreparedStatement pst = cnt.prepareStatement("insert into fhf_produto values(?,?,?,?,?,?,?)");
            pst.setInt(1, produto.getIdproduto());
            pst.setString(2, produto.getNome());
            pst.setString(3, produto.getDescricao());
            pst.setString(4, produto.getPreco());
            pst.setInt(5, produto.getQuantidade());
            pst.setInt(6, produto.getTipo());
            java.sql.Date dataAdicao = new java.sql.Date(produto.getDataAdicao().getTime());
            pst.setDate(7, (dataAdicao));

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Produto produto = (Produto) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("update fhf_produto set fhf_nome=?, fhf_descricao=?, fhf_preco=?, fhf_quantidade=?, fhf_tipo=?, fhf_dataAdicao=? where fhf_idProduto=?");
            pst.setInt(7, produto.getIdproduto());
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getDescricao());
            pst.setString(3, produto.getPreco());
            pst.setInt(4, produto.getQuantidade());
            pst.setInt(5, produto.getTipo());
            java.sql.Date dataAdicao = new java.sql.Date(produto.getDataAdicao().getTime());
            pst.setDate(6, (dataAdicao));
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Produto produto = (Produto) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from fhf_produto where fhf_idProduto =?");
            pst.setInt(1, produto.getIdproduto());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from fhf_produto where fhf_idProduto =?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                Produto produto = new Produto();
                produto.setIdproduto( rs.getInt("fhf_idProduto") );
                produto.setNome(rs.getString("fhf_nome") );
                produto.setDescricao(rs.getString("fhf_descricao") );
                produto.setPreco(rs.getString("fhf_preco") );
                produto.setQuantidade(rs.getInt("fhf_quantidade"));
                produto.setTipo(rs.getInt("fhf_tipo") );
                produto.setDataAdicao(rs.getDate("fhf_dataAdicao") );
                return produto;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {
        PreparedStatement pst;
        List lista;
        try {
            pst = cnt.prepareStatement("select * from fhf_produto");
            ResultSet rs = pst.executeQuery();
            lista = new ArrayList();
            while (rs.next() == true) {
                Produto produto = new Produto();
                produto.setIdproduto(rs.getInt("fhf_idProduto") );
                produto.setNome(rs.getString("fhf_nome") );
                produto.setDescricao(rs.getString("fhf_descricao") );
                produto.setPreco(rs.getString("fhf_preco") );
                produto.setQuantidade(rs.getInt("fhf_quantidade") );
                produto.setTipo(rs.getInt("fhf_tipo") );
                produto.setDataAdicao(rs.getDate("fhf_dataAdicao") );
                lista.add( produto );
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
