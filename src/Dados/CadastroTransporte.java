package Dados;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CadastroTransporte {

    private static Queue<Transporte> transportes;

    public CadastroTransporte() {
        this.transportes = new LinkedList<>();
    }

    public void addTransporte(Transporte t) {
        if (verificaRepetido(t.getNumero())) {
            System.out.println("Erro: Transporte com número já existente.");
            return;
        }
        transportes.add(t);
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
        Queue<Transporte> pendentes = new LinkedList<>();
        for (Transporte t : transportes) {
            if (t.getSituacao() == Estado.PENDENTE) {
                pendentes.add(t);
            }
        }
        return pendentes;
    }

    public String gerarRelatorioTransportes() {
        if (transportes.isEmpty()) {
            return "Nenhum transporte cadastrado no sistema.";
        }
        StringBuilder relatorio = new StringBuilder("Relatório de Transportes:\n");
        for (Transporte transporte : transportes) {
            relatorio.append(transporte.toString()).append("\n\n");
        }
        return relatorio.toString();
    }



    public String alterarSituacao(int numeroTransporte, String situacao) {

        for (Transporte transporte : transportes) {

            if (transporte.getNumero() == numeroTransporte) {

                if(transporte.getSituacao() == Estado.TERMINADO || transporte.getSituacao() == Estado.CANCELADO){//
                    return "Erro: Situação não pode ser alterada.";
                }else if(situacao.equalsIgnoreCase("PENDENTE")){
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



    public Queue<Transporte> getTransportes() {
        return transportes;
    }

}