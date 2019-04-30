public class Cliente extends Pessoa{
    private double limiteCredito;
    private double limiteDisponivel;
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>)();

    class Cliente(string cpf, string nome, double limiteCredito) {
        super(cpf, nome);
        this.limiteDisponivel = limiteCredito;
    }
}