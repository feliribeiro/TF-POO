package Dados;


public class TransporteCargaViva extends Transporte {

    private double temperaturaMinima;
    private double temperaturaMaxima;

    public TransporteCargaViva(int tipo, int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, double temperaturaMinima, double temperaturaMaxima) {
        super(tipo, numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
    }

    @Override
    public double calculaCusto() {
        double custoAdicional = 0;
        double custoBase = calculaDistancia() * getDrone().calculaCustoKm();

        if (temperaturaMaxima - temperaturaMinima > 10) {
            custoAdicional += 1000;
        }
        return custoAdicional + custoBase;
    }

    public String toString() {
        return super.toSuperString() + "\nCusto do Transporte De Carga Viva: " + calculaCusto();
    }
}
