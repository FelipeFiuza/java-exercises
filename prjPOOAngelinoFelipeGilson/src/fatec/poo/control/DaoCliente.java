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
    
<<<<<<< HEAD
    public void incluir(Cliente cliente) {
=======
    public void inserir(Cliente cliente) {
>>>>>>> 37100ede3a05bd2f8274ff1c1efa4f692b7a71a1
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
<<<<<<< HEAD
                                                            "limitecred, " +
                                                            "limitedisp) VALUES (?,?,?,?,?,?,?,?,?,?)");
=======
                                                            "limiteCred, " +
                                                            "limiteDisp) VALUES (?,?,?,?,?,?,?,?,?,?)");
>>>>>>> 37100ede3a05bd2f8274ff1c1efa4f692b7a71a1
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
<<<<<<< HEAD
                                                           "limiteDisp = ?" +
                                                           "WHERE cpf = ?");
=======
                                                           "limiteDisp = ?" +                                                        "datatermino_proj = ?," +
                                                           "where cpf = ?");
>>>>>>> 37100ede3a05bd2f8274ff1c1efa4f692b7a71a1
            
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
        
<<<<<<< HEAD
    public Cliente consultar (String cpf) {
=======
     public  Cliente consultar (String cpf) {
>>>>>>> 37100ede3a05bd2f8274ff1c1efa4f692b7a71a1
        Cliente c = null;
       
        PreparedStatement ps = null;
        try {
<<<<<<< HEAD
            ps = conn.prepareStatement("SELECT * FROM clientes WHERE cpf = ?");
=======
            ps = conn.prepareStatement("SELECT * from clientes where cpf = ?");
>>>>>>> 37100ede3a05bd2f8274ff1c1efa4f692b7a71a1
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
<<<<<<< HEAD
                c = new Cliente (cpf, rs.getString("nome"), rs.getDouble("limitecred") );
=======
                c = new Cliente (cpf, rs.getString("nome"), rs.getDouble("limiteCred") );
>>>>>>> 37100ede3a05bd2f8274ff1c1efa4f692b7a71a1
                c.setEndereco(rs.getString("endereco"));
                c.setCidade(rs.getString("cidade"));
                c.setUf(rs.getString("uf"));
                c.setCep(rs.getString("cep"));
                c.setDdd(rs.getString("ddd"));
                c.setTelefone(rs.getString("telefone"));
<<<<<<< HEAD
                c.setLimiteCred(rs.getDouble("limitecred"));
                
            } else System.out.println("CPF não existe no BD");
=======
                c.setLimiteCred(rs.getDouble("limiteCred"));
                c.setLimiteDisp(rs.getDouble("limiteDisp"));
                
            }
>>>>>>> 37100ede3a05bd2f8274ff1c1efa4f692b7a71a1
        }
        catch (SQLException ex) { 
            System.out.println("Erro ao consultar -> " + ex.toString());   
        }
        return (c);
    }    
     
<<<<<<< HEAD
    public void excluir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM clientes WHERE cpf = ?");
=======
     public void excluir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM clientes where cpf = ?");
>>>>>>> 37100ede3a05bd2f8274ff1c1efa4f692b7a71a1
            
            ps.setString(1, cliente.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }
    }
}