package fatec.poo.model;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    private double limiteCred;
    private double limiteDisp;
    private ArrayList<Pedido> pedidos;

    public Cliente(String cpf, String nome, double limiteCredito) {
        super(cpf, nome);
        this.limiteCred = limiteCredito;
        this.limiteDisp = limiteCredito;
        this.pedidos = new ArrayList<Pedido>();
    }

    public double getLimiteCredito() {
        return limiteCred;
    }

    public double getLimiteDisponivel() {
        return limiteDisp;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCred = limiteCredito;
    }    
    
    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
//        pedido.setCliente(this);
    }
}
