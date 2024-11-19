public abstract class Transporte {
private int numero;
private String nomeCliente;
private String descricao;
private double peso;
private double latitudeOrigem;
private double latitudeDestino;
private double longitudeOrigem;
private double longitudeDestino;
private Estado situacao;

    public Transporte(int numero, String nomeCliente, String descricao, double peso,
        double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao) {

        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.descricao = descricao;
        this.peso = peso;
        this.latitudeOrigem = latitudeOrigem;
        this.latitudeDestino = latitudeDestino;
        this.longitudeOrigem = longitudeOrigem;
        this.longitudeDestino = longitudeDestino;
        this.situacao = situacao;
    }

    public abstract double calculaCusto();

}
