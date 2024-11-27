package Dados;

public abstract class DroneCarga extends Drone {
    private double pesoMaximo;

    public DroneCarga(int codigo, double custoFixo, double autonomia, int tipo, double pesoMaximo) {
        super(codigo, custoFixo, autonomia, tipo);
        this.pesoMaximo = pesoMaximo;
    }
    @Override
    public double calculaCustoKm() {
        return 0;
    }
}
