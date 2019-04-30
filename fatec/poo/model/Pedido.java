public class Pedido {
    private String numero;
    private String dataEmissao;
    private String dataPagamento;
    private Boolean formatoPagamento;
    private Boolean situacao;

    class Pedido(String numero, String dataEmissao) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
    }
}