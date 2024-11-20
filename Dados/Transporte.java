package Dados;
import Dados.Drone;

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
private Drone drone;

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
        this.drone = drone;
    }
    public double calculaDistancia() {
        double deltaLatitude = Math.abs(latitudeDestino - latitudeOrigem);
        double deltaLongitude = Math.abs(longitudeDestino - longitudeOrigem);
        return Math.sqrt(Math.pow(deltaLatitude, 2) + Math.pow(deltaLongitude, 2));
    }
    public Drone getDrone() {

        return drone;
    }

    public abstract double calculaCusto();

    public int getNumero() {
        return numero;
    }

    public String toSuperString() {
        return drone.toString() + "\n" + "Número: " + numero + "\nNome do Cliente: " + nomeCliente + "\nDescrição: " + descricao + "\nPeso: " + peso
                + "\nLatitude Origem: " + latitudeOrigem + "\nLatitude Destino: " + latitudeDestino + "\nLongitude Origem: " + longitudeOrigem + "\nLongitude Destino: " +
                longitudeDestino + "\nSituação: " + situacao;

    }
}
