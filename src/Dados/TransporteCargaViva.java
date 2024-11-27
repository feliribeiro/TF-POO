package Dados;


public class TransporteCargaViva extends Transporte {

    private double temperaturaMinima;
    private double temperaturaMaxima;

    public TransporteCargaViva(int tipo, int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, double temperaturaMinima, double temperaturaMaxima) {
        super(3, numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
    }

    @Override
    public double calculaCusto() {
        if (this.getDrone() != null) {
            double custoAdicional = 0;
            double custoBase = calculaDistancia() * getDrone().calculaCustoKm();

            if (temperaturaMaxima - temperaturaMinima > 10) {
                custoAdicional += 1000;
            }
            return custoAdicional + custoBase;
        } else return 0;
    }

    public String toString() {
        if (this.getDrone() != null)
            return super.toSuperString() + "\nCusto do Transporte De Carga Inanimada: " + calculaCusto();
        else return super.toSuperString();
    }
}
