package Aplicacao;

import Dados.CadastroDrone;
import Dados.DronePessoal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formJanelaCadastroDrone {
    private JPanel Painel;
    private JButton voltarButton;
    private JButton confirmarButton;
    private JTextField codigoField1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton mostrarButton;
    private JButton limparButton;
    private JanelaCadastroDrone janelaCadastroDrone;

    public formJanelaCadastroDrone(JanelaCadastroDrone janelaCadastroDrone) {
        CadastroDrone cd = new CadastroDrone();

        this.janelaCadastroDrone = janelaCadastroDrone;
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCadastroDrone.setVisible(false);
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpaField();
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,cd.mostraDrones());
            }
        });
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (cd.eRepetido(Integer.parseInt(codigoField1.getText()))){
                    JOptionPane.showMessageDialog(null, "Este codigo já foi utilizado no cadastro de outro drone."+"\n");
                    limpaField();
                } else {

                    try {
                        int codigo = Integer.parseInt(codigoField1.getText());
                        double custoFixo = Double.parseDouble(textField1.getText());
                        double autonomia = Double.parseDouble(textField2.getText());
                        int qtdMaxima = Integer.parseInt(textField3.getText());
                        cd.addDrone(new DronePessoal(codigo, custoFixo, autonomia, qtdMaxima));
                        JOptionPane.showMessageDialog(null,"Código do Drone: " + codigoField1.getText() + "\n" +
                                "Custo Fixo: " + textField1.getText() + "\n" +
                                "Autonomia: " + textField2.getText() + "\n" +
                                "Quantidade Máxima de Pessoas: " + textField3.getText() + "\n");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erro de formatação: Digite números válidos.");
                        limpaField();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar drone: " + ex.getMessage());
                        limpaField();
                    }
                }
            }
        });
    }
    public JPanel getPainel() {
        return Painel;
    }

    public void limpaField(){
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        codigoField1.setText("");
    }
}
