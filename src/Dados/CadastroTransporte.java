package Dados;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CadastroTransporte {
    private ArrayList<Transporte> transportes;
    private Queue<Transporte> pendentes;
    private CadastroDrone cadastroDrone;

    public CadastroTransporte() {
        this.transportes = new ArrayList<>();
        this.pendentes = new LinkedList<>();
        CadastroDrone cadastroDrone = new CadastroDrone();
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
        for (Transporte t : pendentes) {
                Drone drone = cadastroDrone.getDroneDisponivel(t.getTipo());
                if (drone != null) {
                    t.setDrone(drone);
                    t.setSituacao(Estado.ALOCADO);
                    pendentes.remove(t);
                    return true;
                }
        }
        return false;
    }

    public String gerarRelatorioTransportes() {
        if (transportes.isEmpty()) {
            return "Nenhum transporte cadastrado no sistema.";
        }
        StringBuilder relatorio = new StringBuilder("Relatório de Transportes:\n");
        for (Transporte transporte : transportes) {
            relatorio.append(transporte.toSuperString()).append("\n\n");
        }
        return relatorio.toString();
    }



    public String alterarSituacao(int numeroTransporte, String situacao) {
        for (Transporte transporte : transportes) {
            if (transporte.getNumero() == numeroTransporte) {
                if (transporte.getSituacao() == Estado.TERMINADO || transporte.getSituacao() == Estado.CANCELADO) {//
                    return "Erro: Situação não pode ser alterada.";
                } else if (situacao.equalsIgnoreCase("PENDENTE")) {
                    transporte.setSituacao(Estado.PENDENTE);
                    return "Situação alterada com sucesso.";
                } else if (situacao.equalsIgnoreCase("ALOCADO")) {
                    transporte.setSituacao(Estado.ALOCADO);
                    return "Situação alterada com sucesso.";
                }
            }
        }
        return "Erro: Transporte não encontrado.";
    }

    public ArrayList<Transporte> getTransportes() {
        return transportes;
    }


    public String getTransportePeloNumero(int numero) {
        for (Transporte t : transportes) {
            if (t.getNumero() == numero) {
                return t.toSuperString();
            }
        }
        return "Drone não encontrado.";
    }
}