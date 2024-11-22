package Dados;

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

        public Transporte (int numero, String nomeCliente, String descricao, double peso,
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
            // Raio médio da Terra em quilômetros
            final double RAIO_TERRA = 6371.0;

            double latOrigemRad = Math.toRadians(latitudeOrigem);
            double lonOrigemRad = Math.toRadians(longitudeOrigem);
            double latDestinoRad = Math.toRadians(latitudeDestino);
            double lonDestinoRad = Math.toRadians(longitudeDestino);

            // Diferenças das coordenadas em radianos
            double deltaLat = Math.abs(latDestinoRad - latOrigemRad);
            double deltaLon = Math.abs(lonDestinoRad - lonOrigemRad);

            double haversinePt1 = Math.pow(Math.sin(deltaLat / 2), 2)
                    + Math.cos(latOrigemRad) * Math.cos(latDestinoRad) * Math.pow(Math.sin(deltaLon / 2), 2);
            double haversinePt2 = 2 * Math.asin(Math.sqrt(haversinePt1));

            // Distância final em quilômetros
            return RAIO_TERRA * haversinePt2;
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

    public Estado getSituacao() {
        return situacao;
    }

    public void setSituacao(Estado situacao) {
        this.situacao = situacao;
    }
}
