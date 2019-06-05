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
    
    public void incluir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO clientes(cpf, " +
                                                            "nome, " +
                                                            "endereco, " +
                                                            "cidade, " + 
                                                            "uf, " +
                                                            "cep, " +
                                                            "ddd, " +
                                                            "telefone, " +
                                                            "limitecred, " +
                                                            "limitedisp) VALUES (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCidade());
            ps.setString(5, cliente.getUf());
            ps.setString(6, cliente.getCep());
            ps.setString(7, cliente.getDdd());
            ps.setString(8, cliente.getTelefone());
            ps.setDouble(9, cliente.getLimiteCred());
            ps.setDouble(10, cliente.getLimiteDisp());
            
                      
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao incluir ->" + ex.toString());   
        }
    }
    
    public void alterar(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE clientes SET nome = ?," +
                                                           "endereco = ?, " +
                                                           "cidade = ?, " + 
                                                           "uf = ?, " +
                                                           "cep = ?, " +
                                                           "ddd = ?, " +
                                                           "telefone = ?, " +
                                                           "limiteCred = ?, " +
                                                           "limiteDisp = ?" +
                                                           "WHERE cpf = ?");
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getCidade());
            ps.setString(4, cliente.getUf());
            ps.setString(5, cliente.getCep());
            ps.setString(6, cliente.getDdd());
            ps.setString(7, cliente.getTelefone());
            ps.setDouble(8, cliente.getLimiteCred());
            ps.setDouble(9, cliente.getLimiteDisp());
            ps.setString(10, cliente.getCpf());
            
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println("Erro ao alterar -> " + ex.toString());   
        }
    }
        
    public Cliente consultar (String cpf) {
        Cliente c = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM clientes WHERE cpf = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                c = new Cliente (cpf, rs.getString("nome"), rs.getDouble("limitecred") );
                c.setEndereco(rs.getString("endereco"));
                c.setCidade(rs.getString("cidade"));
                c.setUf(rs.getString("uf"));
                c.setCep(rs.getString("cep"));
                c.setDdd(rs.getString("ddd"));
                c.setTelefone(rs.getString("telefone"));
                c.setLimiteCred(rs.getDouble("limitecred"));
                
            } else System.out.println("CPF não existe no BD");
        }
        catch (SQLException ex) { 
            System.out.println("Erro ao consultar -> " + ex.toString());   
        }
        return (c);
    }    
     
    public void excluir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM clientes WHERE cpf = ?");
            
            ps.setString(1, cliente.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }
    }
}