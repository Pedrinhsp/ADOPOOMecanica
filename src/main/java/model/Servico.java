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
public class Servico implements Preco{
    //Ocorrência de Henrança(superclasse)
    
    int id;
    String servico;
    double preco;
    //Ocorrência de Encapsulamento
    public Servico() {}
    
    
    public Servico(int id, String servico, double preco) {
        this.id = id;
        this.servico = servico;
        this.preco = preco;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
    
    //Implementação de interface
    @Override
    public double getPreco() {
       return preco;
    }
    
    //Implementação de interface
    @Override
        public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
