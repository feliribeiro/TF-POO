package Dados;

public class DroneCargaViva extends DroneCarga {
    private boolean climatizado;

    public DroneCargaViva(int codigo, double custoFixo, double autonomia, int tipo, double pesoMaximo, boolean climatizado) {
        super(codigo, custoFixo, autonomia, 3, pesoMaximo);
        this.climatizado = climatizado;
    }



    @Override
    public double calculaCustoKm() {
        double custoKm = getCustoFixo() / getAutonomia();

        if (climatizado) {
            return custoKm + 20.0;
        } else
            return custoKm + 10.0;
    }
}
