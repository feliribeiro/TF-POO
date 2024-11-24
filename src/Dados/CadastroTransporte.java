package Dados;

import java.util.ArrayList;
import java.util.List;

public class CadastroTransporte {

    private static List<Transporte> transportes;

    public CadastroTransporte() {
        this.transportes = new ArrayList<>();
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

    public List<Transporte> getTransportesPendentes() {
        List<Transporte> pendentes = new ArrayList<>();
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