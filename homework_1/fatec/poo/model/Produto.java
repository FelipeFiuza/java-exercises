public class Produto {
    private String codigo;
    private String descricao;
    private String unidadeMedida;
    private double qtdeEstoque;
    private double preco;
    private double estoqueMinimo;

    class Produto(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}