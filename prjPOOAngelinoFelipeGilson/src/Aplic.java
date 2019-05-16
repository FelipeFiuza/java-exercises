
import fatec.poo.model.Cliente;
import fatec.poo.model.ItemPedido;
import fatec.poo.model.Pedido;
import fatec.poo.model.Produto;
import fatec.poo.model.Vendedor;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Inspiron7559
 */
public class Aplic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        Cliente c1 = new Cliente("999999", "Ze", 5000);
        c1.setEndereco("Rua 1");
        c1.setCidade("Itu");
        c1.setUf("SP");
        c1.setCep("123");
        c1.setDdd("11");
        c1.setTelefone("5555");
        
        Cliente c2 = new Cliente("999998", "Jo", 8000);
        c2.setEndereco("Rua 2");
        c2.setCidade("Sorocaba");
        c2.setUf("SP");
        c2.setCep("124");
        c2.setDdd("15");
        c2.setTelefone("6666");
        
        Vendedor v1 = new Vendedor("88888", "Maria", 900);
        //set taxa de comissao as 7%
        v1.setTaxaComissao(7);
        
        Vendedor v2 = new Vendedor("88887", "Francisco", 950);
        //set taxa de comissao as 9%
        v2.setTaxaComissao(9);
        
        
        Pedido p1 = new Pedido("0001", "02/05/2019");
        
        Pedido p2 = new Pedido("0002", "03/05/2019");
        
        p1.setVendedor(v1);
        p1.setCliente(c1);
        
        p2.setVendedor(v2);
        p2.setCliente(c2);
        
        Produto prd1 = new Produto("9001", "Coxinha");
        prd1.setQtdeEstoque(80);
        prd1.setUnidadeMedida("unidades");
        prd1.setPreco(3.5);
        prd1.setEstoqueMinimo(20);
        
        Produto prd2 = new Produto("9002", "Kibe");
        prd2.setQtdeEstoque(60);
        prd2.setUnidadeMedida("unidades");
        prd2.setPreco(2.5);
        prd2.setEstoqueMinimo(15);
        
        Produto prd3 = new Produto("9003", "Coca-cola");
        prd3.setQtdeEstoque(100);
        prd3.setUnidadeMedida("latas");
        prd3.setPreco(3.0);
        prd3.setEstoqueMinimo(30);
        
        ItemPedido ip1 = new ItemPedido(1, 3, prd1);
        ItemPedido ip2 = new ItemPedido(2, 2, prd2);
        ItemPedido ip3 = new ItemPedido(1, 1, prd3);
        
        p1.addItem(ip1);
        p1.addItem(ip2);
        p2.addItem(ip3);
        
        System.out.println("\nPedido: " + p1.getNumero() +
                           "\nData: " + p1.getDataEmissao() +
                           "\nCliente: " + p1.getCliente().getNome() +
                           "\nEndereço: " + p1.getCliente().getEndereco() +
                           "\nCidade: " + p1.getCliente().getCidade() +
                           "\tUF: " + p1.getCliente().getUf() +
                           "\nCEP: " + p1.getCliente().getCep() +
                           "\tTelefone: (" + p1.getCliente().getDdd() + ") " + p1.getCliente().getTelefone() +
                           "\nVendedor: " + p1.getVendedor().getNome()
        );
        p1.setSituacao(true);
        System.out.println("Limite Disp: R$ " + c1.getLimiteDisp());
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
