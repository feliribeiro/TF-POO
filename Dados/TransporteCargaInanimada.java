public class TransporteCargaInanimada extends Transporte{
    private boolean cargaPerigosa;

    public TransporteCargaInanimada(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao) {
        super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
    }

    @Override
    public double calculaCusto() {
        return 0;
    }
}
