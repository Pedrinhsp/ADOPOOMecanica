/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pedrin
 */
public class Conserto extends Servico{
    //Ocorrência de Henrança

    String conserto;
//Ocorrência de Encapsulamento

    public String getConserto() {
        return conserto;
    }

    public void setConserto(String conserto) {
        this.conserto = conserto;
    }

    public Conserto() {
    }

    public Conserto(String conserto, int id, String servico, double preco) {
        super(id, servico, preco);
        this.conserto = conserto;
    }

    public Conserto(String conserto) {
        this.conserto = conserto;
    }

}
