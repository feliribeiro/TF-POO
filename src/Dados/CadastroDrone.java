
package Dados;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CadastroDrone {

    private ArrayList<Drone> drones;
    private Comparador c;
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
        ArrayList<Drone> droneOrdenados = drones;
        drones.sort(c);
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
    public void escreverDronesEmArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {

            if (drones.isEmpty()) {
                writer.write("Nenhum drone cadastrado.");
                return;
            }

            for (Drone drone : drones) {
                writer.write(drone.toString());
                writer.newLine();
            }

            System.out.println("Dados dos drones foram salvos no arquivo " + nomeArquivo);

        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados no arquivo: " + e.getMessage());
        }
    }

    //METODO PARA GERAR O JSON SALVADADOS

    public ArrayList<Drone> getDrones() {
        return drones;
    }

}
