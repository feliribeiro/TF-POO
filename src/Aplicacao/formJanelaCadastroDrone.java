package Aplicacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formJanelaCadastroDrone {
    private JPanel Painel;
    private JButton voltarButton;
    private JButton confirmarButton;
    private JanelaCadastroDrone janelaCadastroDrone;

    public formJanelaCadastroDrone(JanelaCadastroDrone janelaCadastroDrone) {
        this.janelaCadastroDrone = janelaCadastroDrone;
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCadastroDrone.setVisible(false);
            }
        });
    }
    public JPanel getPainel() {
        return Painel;
    }
}
