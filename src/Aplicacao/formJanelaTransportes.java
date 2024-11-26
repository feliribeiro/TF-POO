package Aplicacao;

import Dados.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showInputDialog;

public class formJanelaTransportes {
    private JanelaCadastraTransporte janelaCadastraTransporte;
    private JPanel Painel;
    private JButton button1;
    private JRadioButton radioButton1;
    private JLabel titulo;
    private JLabel nomeCliente;
    private JLabel latitudeDeOrigem;
    private JLabel descricaoTxt;
    private JLabel numerotxt;
    private JLabel pesoTxt;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel latitudeDestinoTxt;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton botaoVoltar;
    private JButton botaoConfirmarTxt;
    private JLabel longitudeDeOrigem;
    private JLabel longitudeDestinoTxt;
    private JComboBox selecaoTransporte;

    public formJanelaTransportes(JanelaCadastraTransporte janelaCadastraTransporte) {
        this.janelaCadastraTransporte = janelaCadastraTransporte;

        CadastroTransporte ct = new CadastroTransporte();
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //botao voltar
                janelaCadastraTransporte.setVisible(false);
            }
        });
        botaoConfirmarTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ct.verificaRepetido(Integer.parseInt(numerotxt.getText()))) {
                    JOptionPane.showMessageDialog(null, "Este número já foi utilizado no cadastro de outro transporte." + "\n");
                    limpaField();
                } else {

                    try {
                        String nomeClientes = nomeCliente.getText();
                        int numero = Integer.parseInt(numerotxt.getText());
                        String descricao = descricaoTxt.getText();
                        double peso = Double.parseDouble(pesoTxt.getText());
                        double latitudeOrigem = Double.parseDouble(latitudeDeOrigem.getText());
                        double latitudeDestino = Double.parseDouble(latitudeDestinoTxt.getText());
                        double longitudeOrigem = Double.parseDouble(longitudeDeOrigem.getText());
                        double longitudeDestino = Double.parseDouble(longitudeDestinoTxt.getText());

                        if (selecaoTransporte.getSelectedItem().equals("Pessoal")) {
                            String quantidadePessoas = JOptionPane.showInputDialog(null, "Digite a quantidade máxima de pessoas:", "Quantidade de Pessoas", JOptionPane.QUESTION_MESSAGE);
                            if (quantidadePessoas != null && !quantidadePessoas.isEmpty()) {
                                int qtdMaxima = Integer.parseInt(quantidadePessoas);
                                ct.addTransporte(new TransportePessoal(numero, nomeClientes, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, Estado.PENDENTE, qtdMaxima));
                                JOptionPane.showMessageDialog(null, "Transporte Pessoal cadastrado com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Quantidade de pessoas não informada.");
                            }
                        } if (selecaoTransporte.getSelectedItem().equals("CargaInanimada")) {
                            String cargaPerigosaPal = JOptionPane.showInputDialog(null, "Digite se é ou não uma carga perigosa:", "Carga Perigosa", JOptionPane.QUESTION_MESSAGE);
                            if (cargaPerigosaPal != null && !cargaPerigosaPal.isEmpty()) {
                                boolean cargaPerigosa = Boolean.parseBoolean(cargaPerigosaPal);
                                ct.addTransporte(new TransporteCargaInanimada(numero, nomeClientes, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, Estado.PENDENTE, cargaPerigosa));
                                JOptionPane.showMessageDialog(null, "Transporte de Carga cadastrado com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Carga perigosa não informada.");
                            }
                        } if (selecaoTransporte.getSelectedItem().equals("CargaViva")) {
                            String temperaturaMax = JOptionPane.showInputDialog(null, "Digite a temperatura máxima:", "Temperatura Máxima", JOptionPane.QUESTION_MESSAGE);
                            String temperaturaMin = JOptionPane.showInputDialog(null, "Digite a temperatura mínima:", "Temperatura Mínima", JOptionPane.QUESTION_MESSAGE);
                            if (temperaturaMax != null && !temperaturaMax.isEmpty() && temperaturaMin != null && !temperaturaMin.isEmpty()) {
                                double tempMax = Double.parseDouble(temperaturaMax);
                                double tempMin = Double.parseDouble(temperaturaMin);
                                ct.addTransporte(new TransporteCargaViva(numero, nomeClientes, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, Estado.PENDENTE, tempMin, tempMax));
                                JOptionPane.showMessageDialog(null, "Transporte de Carga Viva cadastrado com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Temperatura não informada.");
                            }
                        }
                        {
                            JOptionPane.showMessageDialog(null, "Selecione um tipo de transporte.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erro de formatação: Digite números válidos.");
                        limpaField();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar drone: " + ex.getMessage());
                        limpaField();
                    }
                }
                JOptionPane.showMessageDialog(null, "Transporte cadastrado com sucesso!");
                janelaCadastraTransporte.setVisible(false);
            }
        });
    }

    public JPanel getPainel() {
        return Painel;
    }

    public void limpaField() {
        nomeCliente.setText("");
        numerotxt.setText("");
        descricaoTxt.setText("");
        pesoTxt.setText("");
        latitudeDeOrigem.setText("");
        latitudeDestinoTxt.setText("");
        longitudeDeOrigem.setText("");
        longitudeDestinoTxt.setText("");
    }

}
