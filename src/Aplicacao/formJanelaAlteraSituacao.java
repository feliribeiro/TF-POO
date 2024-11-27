package Aplicacao;

import Dados.CadastroDrone;
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



    public formJanelaAlteraSituacao(JanelaAlteraSituacao janelaAlteraSituacao) {
        this.janelaAlteraSituacao = janelaAlteraSituacao;
        CadastroTransporte ct = CadastroTransporte.getInstancia();
        CadastroDrone cd = CadastroDrone.getInstancia();
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
                try {
                    int numTransporte = Integer.parseInt(caixaDoNumeroDoTransporte.getText());

                    if (botaoSelecionar.getSelectedItem().equals("ALOCADO")) {
                        JOptionPane.showMessageDialog(null, ct.alterarSituacao(numTransporte, "ALOCADO"));

                    } else if (botaoSelecionar.getSelectedItem().equals("PENDENTE")) {
                        JOptionPane.showMessageDialog(null, ct.alterarSituacao(numTransporte, "PENDENTE"));

                    } else JOptionPane.showMessageDialog(null, "TRANSPORTE NÃO ENCONTRADO");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, digite um número inteiro válido.", "Erro", JOptionPane.ERROR_MESSAGE);
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
