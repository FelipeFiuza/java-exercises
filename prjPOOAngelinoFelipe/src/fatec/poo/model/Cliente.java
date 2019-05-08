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

    public double getLimiteCred() {
        return limiteCred;
    }

    public double getLimiteDisp() {
        return limiteDisp;
    }

    public void setLimiteCred(double limiteCredito) {
        this.limiteCred = limiteCredito;
    }    
    
    public void addPedido(Pedido ped) {
        pedidos.add(ped);
        ped.setCliente(this);
    }

    public void setLimiteDisp(double limiteDisp) {
        this.limiteDisp = limiteDisp;
    }
}
