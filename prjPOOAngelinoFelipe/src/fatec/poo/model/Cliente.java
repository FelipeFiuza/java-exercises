package fatec.poo.model;
import java.util.ArrayList;

public class Cliente extends Pessoa{
    private double limiteCredito;
    private double limiteDisponivel;
//    ArrayList<Pedido> pedidos = new ArrayList<Pedido>)();

    public Cliente(String cpf, String nome, double limiteCredito) {
        super(cpf, nome);
        this.limiteDisponivel = limiteCredito;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }    
}
