package Aplicacao;

import Dados.CadastroTransporte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formJanelaAlteraSituacao {
    private JanelaAlteraSituacao janelaAlteraSituacao;
    private JPanel panel1;
    private JTextField textField1;
    private JButton confirmarButton;
    private JButton voltarButton;
    private JTextField textField2;
    private JButton botaoVoltar;
    private JButton botaoConfirmar;
    private CadastroTransporte ct = new CadastroTransporte();



    public formJanelaAlteraSituacao(JanelaAlteraSituacao janelaAlteraSituacao) {
        this.janelaAlteraSituacao = janelaAlteraSituacao;



        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaAlteraSituacao.setVisible(false);
                // Código para voltar ao menu principal
                // Exemplo: new MenuPrincipal().setVisible(true);
            }
        });
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.getText();
                textField2.getText();
                String metodoAltera = ct.alterarSituacao(Integer.parseInt(textField1.getText()),textField2.getText());
                JOptionPane.showMessageDialog(null, metodoAltera);


            }
        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public JPanel getPainel() {
        return panel1;
    }

}
