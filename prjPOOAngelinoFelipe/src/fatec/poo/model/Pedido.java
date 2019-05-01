package fatec.poo.model;

public class Pedido {
    private String numero;
    private String dataEmissao;
    private String dataPagamento;
    private Boolean formatoPagamento;
    private Boolean situacao;

    public Pedido(String numero, String dataEmissao) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setFormatoPagamento(Boolean formatoPagamento) {
        this.formatoPagamento = formatoPagamento;
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

    public String getDataPagamento() {
        return dataPagamento;
    }

    public Boolean getFormatoPagamento() {
        return formatoPagamento;
    }

    public Boolean getSituacao() {
        return situacao;
    }
}
