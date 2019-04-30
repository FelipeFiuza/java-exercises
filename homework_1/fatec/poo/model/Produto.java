public class Produto {
    private string codigo;
    private string descricao;
    private string unidadeMedida;
    private double qtdeEstoque;
    private double preco;
    private double estoqueMinimo;

    class Produto(string codigo, string descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}