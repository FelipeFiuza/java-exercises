public class ItemPedido {
    private int sequencia;
    private double qtdeVendida;

    class ItemPedido(int sequencia, double qtdeVendida, Produto produto) {
        this.sequencia = sequencia;
        this.qtdeVendida = qtdeVendida;
        produto.setQtdeEstoque(this.qtdeVendida);
    }
}