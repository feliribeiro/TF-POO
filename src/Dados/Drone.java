package Dados;

public abstract class Drone {
    private int codigo;
    private double custoFixo;
    private double autonomia;
    private int tipo;

    public Drone(int codigo, double custoFixo, double autonomia, int tipo) {
        this.codigo = codigo;
        this.custoFixo = custoFixo;
        this.autonomia = autonomia;
        this.tipo = this.tipo;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return "\nCódigo: " + codigo + "\n Custo Fixo: " + custoFixo + "\n Autonomia: " + autonomia;
    }
}
