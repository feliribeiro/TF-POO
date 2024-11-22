package Dados;

public class DroneCargaInanimada extends DroneCarga {
    private boolean protecao;

    public DroneCargaInanimada(int codigo, double custoFixo, double autonomia, double pesoMaximo, boolean protecao) {
        super(codigo, custoFixo, autonomia, pesoMaximo);
        this.protecao = protecao;
    }


    @Override
    public double calculaCustoKm() {
        double custoKm = getCustoFixo() / getAutonomia();
        if (protecao) {
            return custoKm + 10;
        } else
            return custoKm + 5;
    }
}
