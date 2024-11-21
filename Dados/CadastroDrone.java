
package Dados;

import java.util.ArrayList;

public class CadastroDrone {

    private ArrayList<Drone> drones;

    public CadastroDrone() {
        drones = new ArrayList<>();
    }

    public void addDrone(Drone d) {
        if (verificaRepetido(d.getCodigo())) {
            System.out.println("Erro: Drone com código já existente.");
            return;
        }
        drones.add(d);
    }

    public boolean verificaRepetido(int codigoDrone) {
        for (Drone drone : drones) {
            if (drone.getCodigo() == codigoDrone)
                return true;
        }
        return false;
    }

    public void printDrones() {
        for (Drone drone : drones) {
            System.out.println(drone);
        }
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


}
