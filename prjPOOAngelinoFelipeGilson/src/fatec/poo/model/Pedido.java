package fatec.poo.model;

import java.util.ArrayList;

public class Pedido {
    private String numero;
    private String dataEmissao;
    private String dataPagto;
    private Boolean formaPagto;
    private Boolean situacao;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<ItemPedido> itens;

    public Pedido(String numero, String dataEmissao) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.situacao = true;
        itens = new ArrayList<ItemPedido>();
    }

    public void setDataPagto(String dataPagamento) {
        this.dataPagto = dataPagamento;
    }

    public void setFormaPagto(Boolean formaPagamento) {
        this.formaPagto = formaPagamento;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public String getNumero() {
        return numero;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public String getDataPagto() {
        return dataPagto;
    }

    public Boolean getFormaPagto() {
        return formaPagto;
    }

    public Boolean getSituacao() {
        return situacao;
    }
    
    // Testar
    public void addItem(ItemPedido itemPedido){
        itens.add(itemPedido);
        itemPedido.setPedido(this);
        
        if(this.getSituacao()) {
           double limiteAtual = cliente.getLimiteDisp();
           cliente.setLimiteDisp(limiteAtual - itemPedido.getQtdeVendida() * itemPedido.getProduto().getPreco());
        }
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
    
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
  
}
