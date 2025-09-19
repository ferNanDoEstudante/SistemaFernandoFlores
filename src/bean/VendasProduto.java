/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author User
 */
public class VendasProduto {
    private int idvendasproduto;
    private int quantidade;
    private int precoUnitario;
    private int fkidvendas;
    private int fkidproduto;

    public int getIdvendasproduto() {
        return idvendasproduto;
    }

    public void setIdvendasproduto(int idvendasproduto) {
        this.idvendasproduto = idvendasproduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(int precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getFkidvendas() {
        return fkidvendas;
    }

    public void setFkidvendas(int fkidvendas) {
        this.fkidvendas = fkidvendas;
    }

    public int getFkidproduto() {
        return fkidproduto;
    }

    public void setFkidproduto(int fkidproduto) {
        this.fkidproduto = fkidproduto;
    }
}
