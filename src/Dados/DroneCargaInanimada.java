package Dados;

public class DroneCargaInanimada extends DroneCarga {
    private boolean protecao;

    public DroneCargaInanimada(int codigo, double custoFixo, double autonomia, int tipo, double pesoMaximo, boolean protecao) {
        super(codigo, custoFixo, autonomia, 2, pesoMaximo);
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
