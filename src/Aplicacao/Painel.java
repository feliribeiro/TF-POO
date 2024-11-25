package Aplicacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Painel {
    private JPanel Painel;
    private JButton finalizarSistemaButton;
    private JButton cadastrarNovoDroneButton;
    private JButton carregarDadosButton;
    private JButton cadastrarNovoTransporteButton;
    private JButton salvarDadosButton;
    private JButton realizarLeituraDeDadosButton;
    private JButton processarTransportesPendentesButton;
    private JButton alterarASituaçãoDeButton;
    private JButton mostrarTodosOsTransportesButton;
    private JButton mostrarRelatórioGeralButton;
    private Dados.CadastroTransporte ct = new Dados.CadastroTransporte();

    public Painel() {
        ACMEAirDrones ACMEAirDrone = new ACMEAirDrones();

        finalizarSistemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cadastrarNovoDroneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JanelaCadastroDrone JCD = new JanelaCadastroDrone();
            }
        });
        cadastrarNovoTransporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaCadastraTransporte JCT = new JanelaCadastraTransporte();
            }
        });
        mostrarRelatórioGeralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ACMEAirDrone.mostraRelatorioGeral();
            }
        });
        salvarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ACMEAirDrone.salvarDados();
            }
        });
        carregarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame o método correspondente em ACMEAirDrones
            }
        });
        salvarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame o método correspondente em ACMEAirDrones
            }
        });
        realizarLeituraDeDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame o método correspondente em ACMEAirDrones
            }
        });
        processarTransportesPendentesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ct.getTransportesPendentes().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum transporte pendente.");
                } else {
                    JOptionPane.showMessageDialog(null, ct.getTransportesPendentes());
                }

            }
        });

        mostrarTodosOsTransportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(ct.getTransportesPendentes().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Nenhum transporte pendente.");
                    } else {
                        JOptionPane.showMessageDialog(null, ct.gerarRelatorioTransportes());
                    }

            }
        });
    }
        public JPanel getPainel() {
        return Painel;
    }
    }
