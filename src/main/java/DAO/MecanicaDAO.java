/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Conserto;
import model.Melhoria;
import model.Servico;

/**
 *
 * @author Pedrin
 */
public class MecanicaDAO {
    
    // nome do banco: lojaComputador
    public static String URL = "jdbc:mysql://localhost:3306/mecanicaautomoville?UseTimezone=true&serverTimezone=UTC&useSSL=false";
    public static String login = "root";
    public static String senha = "";
    
    public static boolean salvar(Servico p) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha); // (URL, LOGIN E SENHA)
            instrucaoSQL = conexao.prepareStatement("INSERT INTO servico (servico,conserto, melhoria, preco)VALUES( ?,'x','x',  ?);", Statement.RETURN_GENERATED_KEYS); //Caso queira retornar o ID
            instrucaoSQL.setString(1, p.getServico());
            instrucaoSQL.setDouble(2, p.getPreco());
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                    p.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID .");
                }
            } else {
                retorno = false;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
//Libero os recursos da memória
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }
    
    public static boolean salvarConserto(Conserto p) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha); // (URL, LOGIN E SENHA)
            instrucaoSQL = conexao.prepareStatement("INSERT INTO servico (servico, conserto,melhoria, preco)VALUES( 'Mecânico', ?,'x',  ?)", Statement.RETURN_GENERATED_KEYS); //Caso queira retornar o ID
            instrucaoSQL.setString(1, p.getConserto());
            instrucaoSQL.setDouble(2, p.getPreco());
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                    p.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID .");
                }
            } else {
                retorno = false;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
//Libero os recursos da memória
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }
    
    public static boolean salvarMelhoria(Melhoria p) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha); // (URL, LOGIN E SENHA)
            instrucaoSQL = conexao.prepareStatement("INSERT INTO servico (servico,conserto,melhoria , preco)VALUES('Mecânico','x', ?,  ?)", Statement.RETURN_GENERATED_KEYS); //Caso queira retornar o ID
            instrucaoSQL.setString(1, p.getMelhoria());
            instrucaoSQL.setDouble(2, p.getPreco());
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                    p.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID .");
                }
            } else {
                retorno = false;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
//Libero os recursos da memória
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }
    
    public static boolean excluir(int pID){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - DriverManager para abrir a conexão
            String URL = "jdbc:mysql://localhost:3306/mecanicaautomoville?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, login, senha);
            
            instrucaoSQL = conexao.prepareStatement("DELETE FROM servico WHERE id_servico = ?");
            
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setInt(1, pID);

            //Mando executar a instrução SQL
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
            }
            else{
                retorno = false;
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                conexao.close();
                
              } catch (SQLException ex) {
             }
        }
        
        return retorno;
    }
    
    public static boolean excluirTudo(){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/mecanicaautomoville?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, login, senha);
            
            instrucaoSQL = conexao.prepareStatement("TRUNCATE TABLE servico;");

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
            }
            else{
                retorno = false;
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                conexao.close();
                
              } catch (SQLException ex) {
             }
        }
        
        return retorno;
    }
    
    public static ArrayList<Servico> consultarRetiradaServico(String pChamado)
    {
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        ArrayList<Servico> listaServicos = new ArrayList<Servico>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(URL, login, senha);
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM servico WHERE melhoria like 'x' and conserto like 'x';");
            

            rs = instrucaoSQL.executeQuery();
            
            // Enquanto tiver linhas..
            while(rs.next())
            {
                Servico objCliente = new Servico();
                objCliente.setId(rs.getInt("id_servico"));
                objCliente.setServico(rs.getString("servico"));
                objCliente.setPreco(rs.getDouble("preco"));
                listaServicos.add(objCliente);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaServicos = null;
        } finally{
            //Libero os recursos da memória
            try {
                if(rs!=null)
                    rs.close();                
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                        
              } catch (SQLException ex) {
             }
        }
        
        return listaServicos;
    }
    
    public static ArrayList<Melhoria> consultarRetiradaMelhoria(String pChamado)
    {
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        ArrayList<Melhoria> listaServicos = new ArrayList<Melhoria>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(URL, login, senha);
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM servico WHERE melhoria != 'x';");
           

            rs = instrucaoSQL.executeQuery();
            
            // Enquanto tiver linhas..
            while(rs.next())
            {
                Melhoria objCliente = new Melhoria();
                objCliente.setId(rs.getInt("id_servico"));
                objCliente.setServico(rs.getString("servico"));
                objCliente.setMelhoria(rs.getString("melhoria"));
                objCliente.setPreco(rs.getDouble("preco"));
                listaServicos.add(objCliente);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaServicos = null;
        } finally{
            //Libero os recursos da memória
            try {
                if(rs!=null)
                    rs.close();                
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                        
              } catch (SQLException ex) {
             }
        }
        
        return listaServicos;
    }
    
    public static ArrayList<Conserto> consultarRetiradaConserto(String pChamado)
    {
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        ArrayList<Conserto> listaServicos = new ArrayList<Conserto>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(URL, login, senha);
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM servico WHERE conserto != 'x';");

            rs = instrucaoSQL.executeQuery();
            
            // Enquanto tiver linhas..
            while(rs.next())
            {
                Conserto objCliente = new Conserto();
                objCliente.setId(rs.getInt("id_servico"));
                objCliente.setServico(rs.getString("servico"));
                objCliente.setConserto(rs.getString("conserto"));
                objCliente.setPreco(rs.getDouble("preco"));
                listaServicos.add(objCliente);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaServicos = null;
        } finally{
            //Libero os recursos da memória
            try {
                if(rs!=null)
                    rs.close();                
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                        
              } catch (SQLException ex) {
             }
        }
        
        return listaServicos;
    }
    
    public static double obterTotal()
    {
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        
        ArrayList<Servico> listaServicos = new ArrayList<Servico>();
        double resultado = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(URL, login, senha);
            instrucaoSQL = conexao.prepareStatement("SELECT sum(preco) FROM servico;");
            
            rs = instrucaoSQL.executeQuery();
            
            // Enquanto tiver linhas..
            while(rs.next())
            {
                Servico objCliente = new Servico();
                objCliente.setPreco(rs.getDouble("sum(preco)"));
                listaServicos.add(objCliente);
                resultado = rs.getDouble("sum(preco)");
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaServicos = null;
        } finally{
            //Libero os recursos da memória
            try {
                if(rs!=null)
                    rs.close();                
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                        
              } catch (SQLException ex) {
             }
        }
        
        return resultado;
    }
    
}
