package Aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formJanelaAlteraSituacao {
    private JanelaAlteraSituacao janelaAlteraSituacao;
    private JPanel panel1;
    private JTextField textField1;
    private JButton botaoVoltar;
    private JButton botaoConfirmar;

    public formJanelaAlteraSituacao(JanelaAlteraSituacao janelaAlteraSituacao) {
        this.janelaAlteraSituacao = janelaAlteraSituacao;
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public Container getPainel() {
        return null;
    }
}
