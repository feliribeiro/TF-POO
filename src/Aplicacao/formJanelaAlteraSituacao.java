package Aplicacao;

import Dados.CadastroDrone;
import Dados.CadastroTransporte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formJanelaAlteraSituacao {
    private JanelaAlteraSituacao janelaAlteraSituacao;
    private JPanel panel1;
    private JTextField caixaDoNumeroDoTransporte;
    private JButton confirmarButton;
    private JButton voltarButton;
    private JComboBox botaoSelecionar;
    private JButton Limpar;
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
        confirmarButton.addActionListener(e -> {
            try {
                int numTransporte = Integer.parseInt(caixaDoNumeroDoTransporte.getText());
                JOptionPane.showMessageDialog(null, ct.getTransportePeloNumero(numTransporte));

                if (botaoSelecionar.getSelectedItem().equals("ALOCADO")) {

                    JOptionPane.showMessageDialog(null, ct.alterarSituacao(numTransporte, "ALOCADO"));

                } else if(botaoSelecionar.getSelectedItem().equals("TERMINADO")){
                    JOptionPane.showMessageDialog(null, ct.alterarSituacao(numTransporte, "TERMINADO"));

                }else if (botaoSelecionar.getSelectedItem().equals("PENDENTE")) {
                    JOptionPane.showMessageDialog(null, ct.alterarSituacao(numTransporte, "PENDENTE"));

                } else if(botaoSelecionar.getSelectedItem().equals("CANCELADO")) {
                    JOptionPane.showMessageDialog(null, ct.alterarSituacao(numTransporte, "CANCELADO"));
                }else {
                    JOptionPane.showMessageDialog(null, "TRANSPORTE NÃO ENCONTRADO");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número inteiro válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        botaoSelecionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caixaDoNumeroDoTransporte.setText("");
                botaoSelecionar.setSelectedIndex(0);
            }
        });
    }
    public JPanel getPainel() {
        return panel1;
    }
    private void createUIComponents() {
    panel1 = new JPanel();
    panel1.setBackground(new java.awt.Color(0, 0, 128)); // Azul marinho
        }
    }

