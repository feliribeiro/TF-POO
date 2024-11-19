public class TransportePessoal extends Transporte {
    private int qtdPessoas;

    public TransportePessoal(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao) {
        super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
    }

    @Override
    public double calculaCusto() {
        return 0;
    }
}
