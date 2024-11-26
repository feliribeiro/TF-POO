package Aplicacao;



import Dados.Drone;
import Dados.Transporte;

import javax.swing.*;
import Dados.CadastroTransporte;
import Dados.CadastroDrone;


public class ACMEAirDrones extends JFrame {

    private Painel form; // Criado no editor
    private CadastroDrone cadastroDrone;
    private CadastroTransporte cadastroTransporte;

    public ACMEAirDrones() {
        super();
        cadastroDrone = new CadastroDrone();
        cadastroTransporte = new CadastroTransporte();

    }

    public void executar() {
        form = new Painel();
        this.add(form.getPainel());
        this.setSize(530, 450);
        this.setTitle("ACMEAirDrones");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void cadastrarNovoDrone(Drone drone ) {
        cadastroDrone.addDrone(drone);
    }

    public void cadastraTransporte(Transporte transporte) {
        cadastroTransporte.addTransporte(transporte);
    }

    public void processaTransportesPendentes() {
        cadastroTransporte.getTransportesPendentes();
    }

    public void mostraRelatorioGeral() {
        JOptionPane.showMessageDialog(null, cadastroDrone.gerarRelatorioDrones() + "\n" +
                cadastroTransporte.gerarRelatorioTransportes());
    }

    public void salvarDados() {
        String nomeArquivo = JOptionPane.showInputDialog(null, "Digite o nome do arquivo para salvar os dados:", "Nome do arquivo", JOptionPane.PLAIN_MESSAGE);
        if (nomeArquivo == null || nomeArquivo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum nome foi digitado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
}