
package Dados;

import java.util.ArrayList;

public class CadastroDrone {

    private ArrayList<Drone> drones;
    private Comparador c;

    public CadastroDrone() {
        drones = new ArrayList<>();
    }

    public void addDrone(Drone d) {
        if (verificaRepetido(d.getCodigo())) {
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

    public boolean verificaRepetido(int codigoDrone) {
        for (Drone drone : drones) {
            if (drone.getCodigo() == codigoDrone)
                return true;
        }
        return false;
    }

    public String mostraDrones() {
        drones.sort(c);
        ArrayList<Drone> droneOrdenados = drones;
        StringBuilder sb = new StringBuilder();
        for (Drone drone : droneOrdenados) {
            sb.append(drone.toString()).append("\n");
        }
        return sb.toString();
    }

    public boolean eRepetido(int codigo){
        if (drones == null || drones.isEmpty()) {
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
            relatorio.append(drone.toString())
                    .append("\nCusto por Km: ")
                    .append(String.format("%.2f", drone.calculaCustoKm()))
                    .append("\n\n");
        }
        return relatorio.toString();
    }

    //METODO PARA GERAR O JSON SALVADADOS

    public ArrayList<Drone> getDrones() {
        return drones;
    }

}
