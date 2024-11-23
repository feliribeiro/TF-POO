package Dados;

import java.util.ArrayList;
import java.util.List;

public class CadastroTransporte {

    private static List<Transporte> transportes;

    public CadastroTransporte() {
        this.transportes = new ArrayList<>();
    }

    public void addTransporte(Transporte transporte) {
        if (verificaRepetido(transporte.getNumero())) {
            System.out.println("Erro: Transporte com número já existente.");
            return;
        }
        transportes.add(transporte);
    }

    public boolean verificaRepetido(int numeroTransporte) {
        for (Transporte transporte : transportes) {
            if (transporte.getNumero() == numeroTransporte) {
                return true;
            }
        }
        return false;
    }

    public List<Transporte> getTransportesPendentes() {
        List<Transporte> pendentes = new ArrayList<>();
        for (Transporte transporte : transportes) {
            if (transporte.getSituacao() == Estado.PENDENTE) {
                pendentes.add(transporte);
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

    public void alterarSituacao(int numeroTransporte, Estado situacao) {
        for (Transporte transporte : transportes) {
            if (transporte.getNumero() == numeroTransporte) {
                transporte.setSituacao(situacao);
                return;
            }
        }
        System.out.println("Erro: Transporte não encontrado.");
    }
    //metodo

}