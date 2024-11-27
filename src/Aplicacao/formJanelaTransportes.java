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
    private JLabel titulo1;
    private JLabel titulo5;
    private JLabel titulo3;
    private JLabel titulo2;
    private JLabel titulo4;
    private JTextField nomeClienteTxt;
    private JTextField numTransporte;
    private JTextField descricaoTxt;
    private JTextField pesoTxt;
    private JTextField latOrigemTxt;
    private JLabel titulo6;
    private JTextField latDestinoTxt;
    private JTextField longOrigemTxt;
    private JTextField longDestinoTxt;
    private JButton botaoVoltar;
    private JButton botaoConfirmarTxt;
    private JLabel titulo7;
    private JLabel titulo8;
    private JComboBox selecaoTransporte;
    private JButton limparButton;

    public formJanelaTransportes(JanelaCadastraTransporte janelaCadastraTransporte) {
        this.janelaCadastraTransporte = janelaCadastraTransporte;
        CadastroTransporte ct = CadastroTransporte.getInstancia();

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //botao voltar
                janelaCadastraTransporte.setVisible(false);
            }
        });
        botaoConfirmarTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ct.verificaRepetido(Integer.parseInt(numTransporte.getText()))) {
                    JOptionPane.showMessageDialog(null, "Este número já foi utilizado no cadastro de outro transporte." + "\n");
                    limpaField();
                } else {
                    try {
                        String nomeClientes = nomeClienteTxt.getText();
                        int numero = Integer.parseInt(numTransporte.getText());
                        String descricao = descricaoTxt.getText();
                        double peso = Double.parseDouble(pesoTxt.getText());
                        double latitudeOrigem = Double.parseDouble(latOrigemTxt.getText());
                        double latitudeDestino = Double.parseDouble(latDestinoTxt.getText());
                        double longitudeOrigem = Double.parseDouble(longOrigemTxt.getText());
                        double longitudeDestino = Double.parseDouble(longDestinoTxt.getText());

                        if (selecaoTransporte.getSelectedItem().equals("Pessoal")) {
                            String quantidadePessoas = JOptionPane.showInputDialog(null, "Digite a quantidade máxima de pessoas:", "Quantidade de Pessoas", JOptionPane.QUESTION_MESSAGE);
                            if (quantidadePessoas != null || !quantidadePessoas.isEmpty()) {
                                int qtdMaxima = Integer.parseInt(quantidadePessoas);
                                TransportePessoal tP = new TransportePessoal(1, numero, nomeClientes, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, Estado.PENDENTE, qtdMaxima);
                                tP.setTipo(1);
                                if(ct.addTransporte(tP)) {
                                    JOptionPane.showMessageDialog(null, "Transporte Pessoal cadastrado com sucesso!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Quantidade de pessoas não informada.");
                            }
                        }

                        if (selecaoTransporte.getSelectedItem().equals("CargaInanimada")) {
                            Boolean cargaPerigosa = null;
                            String cargaPerigosaPal = JOptionPane.showInputDialog(null, "Digite se é ou não uma carga perigosa:", "Carga Perigosa", JOptionPane.QUESTION_MESSAGE);
                            if (cargaPerigosaPal != null || !cargaPerigosaPal.isEmpty()) {
                                if(!cargaPerigosaPal.equalsIgnoreCase("sim") && !cargaPerigosaPal.equalsIgnoreCase("nao")){
                                    JOptionPane.showMessageDialog(null, "Digite sim ou nao.");
                                } else cargaPerigosa = cargaPerigosaPal.equalsIgnoreCase("sim");
                                TransporteCargaInanimada tCI = new TransporteCargaInanimada(2, numero, nomeClientes, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, Estado.PENDENTE, cargaPerigosa);
                                tCI.setTipo(2);
                                if(ct.addTransporte(tCI)) {
                                    JOptionPane.showMessageDialog(null, "Transporte de Carga Inanimada cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                                } else JOptionPane.showMessageDialog(null, "Erro ao adicionar transporte.", "Erro", JOptionPane.ERROR_MESSAGE);

                            } else JOptionPane.showMessageDialog(null, "Carga perigosa não informada.");
                        }
                        if (selecaoTransporte.getSelectedItem().equals("CargaViva")) {
                            String temperaturaMax = JOptionPane.showInputDialog(null, "Digite a temperatura máxima:", "Temperatura Máxima", JOptionPane.QUESTION_MESSAGE);
                            String temperaturaMin = JOptionPane.showInputDialog(null, "Digite a temperatura mínima:", "Temperatura Mínima", JOptionPane.QUESTION_MESSAGE);
                            if (temperaturaMax != null && !temperaturaMax.isEmpty() && temperaturaMin != null && !temperaturaMin.isEmpty()) {
                                double tempMax = Double.parseDouble(temperaturaMax);
                                double tempMin = Double.parseDouble(temperaturaMin);
                                TransporteCargaViva tCV = new TransporteCargaViva(3, numero, nomeClientes, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, Estado.PENDENTE, tempMin, tempMax);
                                tCV.setTipo(3);
                                if(ct.addTransporte(tCV)) {
                                    JOptionPane.showMessageDialog(null, "Transporte de Carga Viva cadastrado com sucesso!");
                                } else JOptionPane.showMessageDialog(null, "Erro ao adicionar transporte.", "Erro", JOptionPane.ERROR_MESSAGE);

                            } else {
                                JOptionPane.showMessageDialog(null, "Temperatura não informada.");
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erro de formatação: Digite números válidos.");
                        limpaField();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar transporte: " + ex.getMessage());
                        limpaField();
                    }
                }
                //JOptionPane.showMessageDialog(null, "Transporte cadastrado com sucesso!");
                //janelaCadastraTransporte.setVisible(false);
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpaField();
            }
        });
    }

    public JPanel getPainel() {
        return Painel;
    }

    public void limpaField() {
        numTransporte.setText("");
        nomeClienteTxt.setText("");
        descricaoTxt.setText("");
        pesoTxt.setText("");
        latDestinoTxt.setText("");
        latOrigemTxt.setText("");
        longDestinoTxt.setText("");
        longOrigemTxt.setText("");
    }

}
