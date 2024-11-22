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

    public Painel() {

        cadastrarNovoDroneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame o método correspondente em ACMEAirDrones
            }
        });

        cadastrarNovoTransporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame o método correspondente em ACMEAirDrones
            }
        });

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
    }

    public JPanel getPainel() {return Painel;}
}
