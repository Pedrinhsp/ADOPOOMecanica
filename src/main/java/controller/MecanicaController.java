/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.MecanicaDAO;
import model.Conserto;
import model.Melhoria;
import model.Servico;

/**
 *
 * @author Pedrin
 */
public class MecanicaController {
     //Ocorrência de Polimorfismo
    public static boolean salvarServico(String pServico, String pPreco){
        Servico comp = new Servico();
        comp.setServico(pServico);
        
        pPreco = pPreco.replace(",",".");
        
        try{
        double precoAlt = Double.parseDouble(pPreco);
        comp.setPreco(precoAlt);}catch(Exception e){
            System.out.println("Preço inválido, digite um número válido");
        }

        return MecanicaDAO.salvar(comp);
    }
    
    //Ocorrência de Polimorfismo
    public static boolean salvarMelhoria(String pMelhoria, String pPreco){
        Melhoria comp = new Melhoria();
        comp.setMelhoria(pMelhoria);
        
        pPreco = pPreco.replace(",",".");
        
        try{
        double precoAlt = Double.parseDouble(pPreco);
        comp.setPreco(precoAlt);}catch(Exception e){
            System.out.println("Preço inválido, digite um número válido");
        }

        return MecanicaDAO.salvarMelhoria(comp);
    }
    
     //Ocorrência de Polimorfismo
    public static boolean salvarConserto(String pConserto, String pPreco){
        Conserto comp = new Conserto();
        comp.setConserto(pConserto);
        
        pPreco = pPreco.replace(",",".");
        
        try{
        double precoAlt = Double.parseDouble(pPreco);
        comp.setPreco(precoAlt);}catch(Exception e){
            System.out.println("Preço inválido, digite um número válido");
        }

        return MecanicaDAO.salvarConserto(comp);
    }
    
     public static boolean excluir(int pChamado){
        return MecanicaDAO.excluir(pChamado);
    }
     
     public static boolean excluirTudo(){
        return MecanicaDAO.excluirTudo();
    }
}
