package aplicacao;

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

        finalizarSistemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public JPanel getPainel() {
        return Painel;
    }
}
