package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Vendedor;

public class DaoVendedor {

    private Connection conn;
    
    public DaoVendedor(Connection conn) {
         this.conn = conn;
    }
    
    public void incluir(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO vendedores(cpf, " +
                                                            "nome, " +
                                                            "endereco, " +
                                                            "cidade, " + 
                                                            "uf, " +
                                                            "cep, " +
                                                            "ddd, " +
                                                            "telefone, " +
                                                            "salarioBase, " +
                                                            "taxaComissao) VALUES (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, vendedor.getCpf());
            ps.setString(2, vendedor.getNome());
            ps.setString(3, vendedor.getEndereco());
            ps.setString(4, vendedor.getCidade());
            ps.setString(5, vendedor.getUf());
            ps.setString(6, vendedor.getCep());
            ps.setString(7, vendedor.getDdd());
            ps.setString(8, vendedor.getTelefone());
            ps.setDouble(9, vendedor.getSalarioBase());
            ps.setDouble(10, vendedor.getTaxaComissao());
                              
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao incluir ->" + ex.toString());   
        }
    }
    
    public void alterar(Vendedor vendedor) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("UPDATE vendedores SET nome = ?," +
                                                           "endereco = ?, " +
                                                           "cidade = ?, " + 
                                                           "uf = ?, " +
                                                           "cep = ?, " +
                                                           "ddd = ?, " +
                                                           "telefone = ?, " +
                                                           "salarioBase = ?, " +
                                                           "taxaComissao = ?" +
                                                           "WHERE cpf = ?");
            
            ps.setString(1, vendedor.getNome());
            ps.setString(2, vendedor.getEndereco());
            ps.setString(3, vendedor.getCidade());
            ps.setString(4, vendedor.getUf());
            ps.setString(5, vendedor.getCep());
            ps.setString(6, vendedor.getDdd());
            ps.setString(7, vendedor.getTelefone());
            ps.setDouble(8, vendedor.getSalarioBase());
            ps.setDouble(9, vendedor.getTaxaComissao());
            ps.setString(10, vendedor.getCpf());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error ao alterar -> " + ex.toString());   
        }
    }
        
    public  Vendedor consultar (String cpf) {
        Vendedor v = null;
        PreparedStatement ps = null;
 
        try {
            ps = conn.prepareStatement("SELECT * FROM vendedores WHERE cpf = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                v = new Vendedor (cpf, rs.getString("nome"), rs.getDouble("salariobase") );
                v.setEndereco(rs.getString("endereco"));
                v.setCidade(rs.getString("cidade"));
                v.setUf(rs.getString("uf"));
                v.setCep(rs.getString("cep"));
                v.setDdd(rs.getString("ddd"));
                v.setTelefone(rs.getString("telefone"));
                v.setSalarioBase(rs.getDouble("salariobase"));
                v.setTaxaComissao(rs.getDouble("taxacomissao"));               
            }
        }
        catch (SQLException ex) { 
            System.out.println("Erro ao consultar -> " + ex.toString());   
        }
        return (v);
    }    
     
    public void excluir(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM vendedores WHERE cpf = ?");
            ps.setString(1, vendedor.getCpf());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar -> " + ex.toString());   
        }
    }
}
