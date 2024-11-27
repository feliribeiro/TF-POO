
package Dados;

import java.util.ArrayList;

public class CadastroDrone {

    private final ArrayList<Drone> drones;
    private final Comparador c;
    private static CadastroDrone instancia;

    public CadastroDrone() {
        drones = new ArrayList<>();
        c = new Comparador();
    }

    public static CadastroDrone getInstancia() {
        if (instancia == null) {
            instancia = new CadastroDrone();
        }
        return instancia;
    }

    public void addDrone(Drone d) {
        if (eRepetido(d.getCodigo())) {
            return;
        }
        drones.add(d);
    }

    public Drone getDroneDisponivel (int tipoTransporte) {
        for (Drone d : drones) {
            if (d.getTipo() == tipoTransporte) {
                return d;
            }
        }
        return null;
    }

    public String mostraDrones() {
        drones.sort(c);
        StringBuilder sb = new StringBuilder();
        for (Drone drone : drones) {
            sb.append(drone.toString()).append("\n");
        }
        return sb.toString();
    }

    public boolean eRepetido(int codigo){
        if (drones.isEmpty()) {
            return false;
        }
        for (Drone drone : drones) {
            if (drone.getCodigo() == codigo){
                return true;
            }
        } return false;
    }

    public String gerarRelatorioDrones() {
        if (drones.isEmpty()) {
            return "Nenhum drone cadastrado no sistema.";
        }
        StringBuilder relatorio = new StringBuilder("Relatório de Drones:\n");
        for (Drone drone : drones) {
            if (drone instanceof DronePessoal)
                relatorio.append("Drone Pessoal:");
            if (drone instanceof DroneCargaViva)
                relatorio.append("Drone Carga Viva:");
            if (drone instanceof DroneCargaInanimada)
                relatorio.append("Drone Carga Inanimada:");
            relatorio.append(drone.toString())
                    .append("\nCusto por Km: ")
                    .append(String.format("%.2f", drone.calculaCustoKm()))
                    .append("\n\n");
        }
        return relatorio.toString();
    }
}
