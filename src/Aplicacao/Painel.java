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
        cadastrarNovoTransporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaCadastraTransporte JCT = new JanelaCadastraTransporte();
            }
        });
        mostrarRelatórioGeralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,".");
            }
        });
        salvarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog(null, "Digite o nome desejado:", "Nome do Arquivo", JOptionPane.PLAIN_MESSAGE);

                if (nome != null && !nome.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nome do arquivo: " + nome, "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum nome foi digitado.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public JPanel getPainel() {return Painel;}
}
