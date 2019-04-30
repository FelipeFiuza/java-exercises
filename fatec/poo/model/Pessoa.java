public class Pessoa {
    private string cpf;
    private string name;
    private string endereco;
    private string uf;
    private string cep;
    private string ddd;
    private string telefone;
    
    class Pessoa(string cpf, string nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
}