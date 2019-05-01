public class Pessoa {
    private String cpf;
    private String name;
    private String endereco;
    private String uf;
    private String cep;
    private String ddd;
    private String telefone;
    
    class Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
}