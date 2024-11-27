package Dados;

public class TransporteCargaInanimada extends Transporte{
    private boolean cargaPerigosa;

    public TransporteCargaInanimada(int tipo, int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, boolean cargaPerigosa) {
        super(2, numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        this.cargaPerigosa = cargaPerigosa;
    }

    @Override
    public double calculaCusto() {
        if (this.getDrone() != null){
            double custoAdicional = 0;
            double custoBase = calculaDistancia() * getDrone().calculaCustoKm();

            if (cargaPerigosa) {
                custoAdicional += 500;
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
