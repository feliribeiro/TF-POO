package Dados;

public abstract class Drone {
    private int codigo;
    private double custoFixo;
    private double autonomia;

    public Drone(int codigo, double custoFixo, double autonomia) {
        this.codigo = codigo;
        this.custoFixo = custoFixo;
        this.autonomia = autonomia;
    }


    public abstract double calculaCustoKm();

    public int getCodigo() {
        return codigo;
    }

    public double getCustoFixo() {

        return custoFixo;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public String toString() {
        return "\nCódigo: " + codigo + "\n Custo Fixo: " + custoFixo + "\n Autonomia: " + autonomia;
    }
}
