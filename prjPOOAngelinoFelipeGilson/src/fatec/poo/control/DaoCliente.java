package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Cliente;

public class DaoCliente {

    private Connection conn;
    
    public DaoCliente(Connection conn) {
         this.conn = conn;
    }
    
    /*public void inserir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO clientes(cpf, " +
                                                             "nome, " +
                                                             "endereco, ") VALUES(?,?,?,?)");
            ps.setInt(1, .getCodigo());
            ps.setString(2, projeto.getDescricao());
            ps.setString(3, projeto.getDataInicio());
            ps.setString(4, projeto.getDataTermino());
            
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Projeto projeto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbprojeto SET descricao_proj = ?," +
                                                 "datainicio_proj = ?," +
                                                 "datatermino_proj = ?," +
                                                 "where codigo_proj = ?");
            
            ps.setString(1, projeto.getDescricao());
            ps.setString(2, projeto.getDataInicio());
            ps.setString(3, projeto.getDataTermino());
            ps.setInt(4, projeto.getCodigo());
            
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Projeto consultar (int codigo) {
        Projeto p = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbprojeto where " +
                                                 "codigo_proj = ?");
            
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                p = new Projeto (codigo, rs.getString("descricao_proj"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (p);
    }    
     
     public void excluir(Projeto projeto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbprojeto where codigo_proj = ?");
            
            ps.setInt(1, projeto.getCodigo());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }*/
}