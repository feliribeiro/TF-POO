package Dados;

public class TransporteCargaInanimada extends Transporte{
    private boolean cargaPerigosa;

    public TransporteCargaInanimada(int tipo, int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, boolean cargaPerigosa) {
        super(tipo, numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        this.cargaPerigosa = cargaPerigosa;
    }

    @Override
    public double calculaCusto() {
        double custoAdicional = 0;
        double custoBase = calculaDistancia() * getDrone().calculaCustoKm();

        if (cargaPerigosa) {
            custoAdicional += 500;
        }
        return custoAdicional + custoBase;
    }

  public String toString() {
      return super.toSuperString() + "\nCusto do Transporte De Carga Inanimada: " + calculaCusto();
  }

}
