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
public class Melhoria extends Servico{
    //Ocorrência de Henrança
    
    
    String melhoria;
   //Ocorrência de Encapsulamento 

    public String getMelhoria() {
        return melhoria;
    }

    public void setMelhoria(String melhoria) {
        this.melhoria = melhoria;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public Melhoria() {
    }

    public Melhoria(String melhoria) {
        this.melhoria = melhoria;
    }

    public Melhoria(String melhoria, int id, String servico, double preco) {
        super(id, servico, preco);
        this.melhoria = melhoria;
    }
    
    
    
}
