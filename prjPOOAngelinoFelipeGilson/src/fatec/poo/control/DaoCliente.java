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
                                                            "limiteCred, " +
                                                            "limiteDisp) VALUES (?,?,?,?,?,?,?,?,?,?)");
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
            System.out.println(ex.toString());   
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
                                                           "where cpf = ?");
            
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
             System.out.println(ex.toString());   
        }
    }
        
    public  Cliente consultar (String cpf) {
        Cliente c = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from CLIENTES where CPF = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                c = new Cliente (cpf, rs.getString("NOME"), rs.getDouble("LIMITECRED") );
                c.setEndereco(rs.getString("ENDERECO"));
                c.setCidade(rs.getString("CIDADE"));
                c.setUf(rs.getString("UF"));
                c.setCep(rs.getString("CEP"));
                c.setDdd(rs.getString("DDD"));
                c.setTelefone(rs.getString("TELEFONE"));
                c.setLimiteCred(rs.getDouble("LIMITECRED"));
                
            } else System.out.println("CPF não existe no BD");
        }
        catch (SQLException ex) { 
            System.out.println("erro do catch" + ex.toString());   
        }
        return (c);
    }    
     
    public void excluir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM clientes where cpf = ?");
            
            ps.setString(1, cliente.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }
    }
}