public class TransporteCargaViva extends Transporte{

    private double temperaturaMinima;
    private double temperaturaMaxima;

    public TransporteCargaViva(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao) {
        super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
    }

    @Override
    public double calculaCusto() {
        return 0;
    }
}
