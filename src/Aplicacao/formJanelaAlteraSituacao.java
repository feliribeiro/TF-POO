package Aplicacao;

import Dados.CadastroTransporte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class formJanelaAlteraSituacao {
    private JanelaAlteraSituacao janelaAlteraSituacao;
    private JPanel panel1;
    private JTextField caixaDoNumeroDoTransporte;
    private JButton confirmarButton;
    private JButton voltarButton;
    private JComboBox botaoSelecionar;
    private JTextField dadosDoTransporte;
    private JTextField textField2;
    private JButton botaoVoltar;
    private JButton botaoConfirmar;
    private CadastroTransporte ct = new CadastroTransporte();



    public formJanelaAlteraSituacao(JanelaAlteraSituacao janelaAlteraSituacao) {
        this.janelaAlteraSituacao = janelaAlteraSituacao;
        caixaDoNumeroDoTransporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaAlteraSituacao.setVisible(false);

            }
        });
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caixaDoNumeroDoTransporte.getText();
                botaoSelecionar.getSelectedItem();


                dadosDoTransporte.setText(ct.getTransportePeloNumero(Integer.parseInt(caixaDoNumeroDoTransporte.getText())));

                if (botaoSelecionar.getSelectedItem().toString().equals("ALOCADO")) {
                    JOptionPane.showMessageDialog(null, ct.alterarSituacao(Integer.parseInt(caixaDoNumeroDoTransporte.getText()), "ALOCADO"));// Código para confirmar a alteração e aparece a a
                } else if (botaoSelecionar.getSelectedItem().toString().equals("PENDENTE")) {
                    JOptionPane.showMessageDialog(null, ct.alterarSituacao(Integer.parseInt(caixaDoNumeroDoTransporte.getText()), "PENDENTE"));// Código para confirmar a alteração e aparece a a
                } else {
                    JOptionPane.showMessageDialog(null, ct.alterarSituacao(Integer.parseInt(caixaDoNumeroDoTransporte.getText()), "TRANSPORTE FINALIZADO"));// Código para confirmar a alteração e aparece a a
                }


            }
        });

        botaoSelecionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        dadosDoTransporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ct.getTransportePeloNumero(Integer.parseInt(dadosDoTransporte.getText()));
            }
        });
    }
    public JPanel getPainel() {
        return panel1;
    }

}
