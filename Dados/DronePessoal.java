package Dados;

import Dados.Drone;

public class DronePessoal extends Drone {
    private int qtdMaxPessoas;

    public DronePessoal(int codigo, double custoFixo, double autonomia, int qtdMaxPessoas) {
        super(codigo, custoFixo, autonomia);
        this.qtdMaxPessoas = qtdMaxPessoas;
    }

    public int getQtdMaxPessoas() {
        return qtdMaxPessoas;
    }

    @Override
    public double calculaCustoKm() {
        double custoPorKm = getCustoFixo() / getAutonomia();
        double acrescimo = qtdMaxPessoas * 2.0;
        return custoPorKm +  acrescimo;
    }

}
