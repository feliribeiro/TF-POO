package Dados;


public class TransportePessoal extends Transporte {
    private int qtdPessoas;

    public TransportePessoal(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, int qtdPessoas) {
        super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        this.qtdPessoas = qtdPessoas;
    }
    @Override
    public double calculaCusto() {
        double custoBase = calculaDistancia() * getDrone().calculaCustoKm();
        double custoAdicional = qtdPessoas * 10;

        return custoBase + custoAdicional;
    }

    public String toString() {
        return super.toSuperString() + "\nCusto do Transporte Pessoal: " + calculaCusto();
    }

}
