/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.util.Date;

/**
 *
 * @author User
 */
public class Vendas {
    private int idvendas;
    private int fkclientes;
    private int fkvendedor;
    private Date data;
    private String formaPagamento;
    private String total;

    public int getIdvendas() {
        return idvendas;
    }

    public void setIdvendas(int idvendas) {
        this.idvendas = idvendas;
    }

    public int getFkclientes() {
        return fkclientes;
    }

    public void setFkclientes(int fkclientes) {
        this.fkclientes = fkclientes;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getFkVendedor() {
        return fkvendedor;
    }

    public void setFkVendedor(int fkvendedor) {
        this.fkvendedor = fkvendedor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public String getTotal(){
        return total;
    }
    
    public void setTotal(String total){
        this.total = total;
    }
}
