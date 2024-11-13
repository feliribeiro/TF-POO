import java.util.ArrayList;

public class CadastroDrone {

    private ArrayList<Drone> drones;

    public CadastroDrone() {
        drones = new ArrayList();
    }

    public void addDrone(Drone d) {
        drones.add(d);
    }
    public boolean verificaRepetido(int c) {
        for (int i = 0; i < drones.size(); i++) {
            if (drones.get(i).getCodigo() == c) return true;
        }
        return false;
    }
    public void printDrones() {
        for (int i = 0; i < drones.size(); i++) {
            System.out.println(drones.get(i));
        }
    }
}
