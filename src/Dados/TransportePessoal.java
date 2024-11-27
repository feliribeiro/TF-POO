package Dados;


public class TransportePessoal extends Transporte {
    private int qtdPessoas;

    public TransportePessoal(int tipo, int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, int qtdPessoas) {
        super(tipo, numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        this.qtdPessoas = qtdPessoas;
    }
    @Override
    public double calculaCusto() {
        if (this.getDrone() != null) {
            double custoBase = calculaDistancia() * getDrone().calculaCustoKm();
            double custoAdicional = qtdPessoas * 10;

            return custoBase + custoAdicional;
        } else return 0;
    }

    public String toString() {
        if (this.getDrone() != null)
            return super.toSuperString() + "\nCusto do Transporte De Carga Inanimada: " + calculaCusto();
        else return super.toSuperString();
    }
}
