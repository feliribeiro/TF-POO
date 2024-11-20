
package Dados;

import java.util.ArrayList;

public class CadastroDrone {

    private ArrayList<Drone> drones;

    public CadastroDrone() {
        drones = new ArrayList<>();
    }

    public void addDrone(Drone d) {
        drones.add(d);
    }

    public boolean verificaRepetido(int codigoDrone) {
        for (Drone drone : drones) {
            if (drone.getCodigo() == codigoDrone) return true;
        }
        return false;
    }

    public void printDrones() {
        for (Drone drone : drones) {
            System.out.println(drone);
        }
    }
}
