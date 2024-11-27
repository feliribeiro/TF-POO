package Dados;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CadastroTransporte {
    private ArrayList<Transporte> transportes;
    private Queue<Transporte> pendentes;
    private CadastroDrone cadastroDrone;
    private static CadastroTransporte instancia;

    public CadastroTransporte() {
        this.transportes = new ArrayList<>();
        this.pendentes = new LinkedList<>();
        this.cadastroDrone = CadastroDrone.getInstancia();
    }

    public String gerarRelatorioTransportes() {
    if (transportes.isEmpty()) return "Nenhum transporte cadastrado no sistema.";
    StringBuilder relatorio = new StringBuilder("*Relatório de Transportes*\n\n");
    for (Transporte transporte : transportes) {
        if (transporte instanceof TransportePessoal) relatorio.append("Transporte Pessoal:\n");
        else if (transporte instanceof TransporteCargaInanimada) relatorio.append("Transporte Carga Inanimada:\n");
        else if (transporte instanceof TransporteCargaViva) relatorio.append("Transporte Carga Viva:\n");

        relatorio.append(transporte.toString())
                .append("\nCusto por Km: ")
                .append(String.format("%.2f", transporte.calculaCusto()))
                .append("\n-------------------------\n");
    }
    return relatorio.toString();
}

    public static CadastroTransporte getInstancia() {
        if (instancia == null) {
            instancia = new CadastroTransporte();
        }
        return instancia;
    }

    public boolean addTransporte(Transporte t) {
        if (verificaRepetido(t.getNumero())) {
            return false;
        }
        t.setSituacao(Estado.PENDENTE);
        transportes.add(t);
        pendentes.add(t);
        return true;
    }

    public boolean verificaRepetido(int numeroTransporte) {
        for (Transporte t : transportes) {
            if (t.getNumero() == numeroTransporte) {
                return true;
            }
        }
        return false;
    }

    public Queue<Transporte> getTransportesPendentes() {
            return pendentes;
    }

    public boolean processaTransportesPendentes() {
        if (!pendentes.isEmpty()) {
            for (Transporte t : pendentes) {
                Drone drone = this.cadastroDrone.getDroneDisponivel(t.getTipo());
                if (drone != null) {
                    t.setDrone(drone);
                    t.setSituacao(Estado.ALOCADO);
                    pendentes.remove(t);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public String alterarSituacao(int numeroTransporte, String situacao) {
        for (Transporte transporte : transportes) {
            if (transporte.getNumero() == numeroTransporte) {
                if (transporte.getSituacao() == Estado.TERMINADO || transporte.getSituacao() == Estado.CANCELADO) {
                    return "Esse transporte já foi finalizado.";
                } else if (situacao.equalsIgnoreCase("PENDENTE")) {
                    transporte.setSituacao(Estado.PENDENTE);
                    return "Transporte alterado para PENDENTE";
                } else if (situacao.equalsIgnoreCase("ALOCADO")) {
                    transporte.setSituacao(Estado.ALOCADO);
                    return "Transporte alterado para ALOCADO";
                }
            }
        }
        return "Transporte não encontrado.";
    }


    public String getTransportePeloNumero(int numero) {
        for (Transporte t : transportes) {
            if (t.getNumero() == numero) {
                return t.toSuperString();
            }
        }
        return "Transporte não encontrado.";
    }
}