package Aplicacao;

import Dados.DroneCargaInanimada;
import Dados.DroneCargaViva;
import Dados.DronePessoal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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
    private Dados.CadastroTransporte ct = new Dados.CadastroTransporte();

    public Painel() {
        ACMEAirDrones ACMEAirDrone = new ACMEAirDrones();

        finalizarSistemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {System.exit(0);}
        });
        cadastrarNovoDroneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaCadastroDrone JCD = new JanelaCadastroDrone();
            }
        });
        cadastrarNovoTransporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaCadastraTransporte JCT = new JanelaCadastraTransporte();
            }
        });
        mostrarRelatórioGeralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ACMEAirDrone.mostraRelatorioGeral();
            }
        });
        salvarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ACMEAirDrone.salvarDados();
            }
        });
        carregarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame o método correspondente em ACMEAirDrones
            }
        });
        salvarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame o método correspondente em ACMEAirDrones
            }
        });
        realizarLeituraDeDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String arquivo = JOptionPane.showInputDialog(null, "Digite o nome do arquivo.");
                try{
                    Scanner input = new Scanner(new FileReader(arquivo));
                    while(input.hasNextLine()){
                        String linha = input.nextLine();
                        String delimeter = ";";
                        String[] dados = linha.split(delimeter);
                        if (dados[0].equals("1")){
                            int codigo = Integer.parseInt(dados[1]);
                            double custoFixo = Double.parseDouble(dados[2]);
                            double autonomia = Double.parseDouble(dados[3]);
                            int qtdMaxima = Integer.parseInt(dados[4]);
                            ACMEAirDrone.cadastrarNovoDrone(new DronePessoal(codigo,custoFixo,autonomia,1,qtdMaxima));
                        }
                        if (dados[0].equals("3")){
                            int codigo = Integer.parseInt(dados[1]);
                            double custoFixo = Double.parseDouble(dados[2]);
                            double autonomia = Double.parseDouble(dados[3]);
                            double pesoMaximo = Double.parseDouble(dados[4]);
                            boolean climatizado = Boolean.parseBoolean(dados[5]);
                            ACMEAirDrone.cadastrarNovoDrone(new DroneCargaViva(codigo,custoFixo,autonomia,3,pesoMaximo,climatizado));
                        }
                        if (dados[0].equals("2")){
                            int codigo = Integer.parseInt(dados[1]);
                            double custoFixo = Double.parseDouble(dados[2]);
                            double autonomia = Double.parseDouble(dados[3]);
                            double pesoMaximo = Double.parseDouble(dados[4]);
                            boolean protecao = Boolean.parseBoolean(dados[5]);
                            ACMEAirDrone.cadastrarNovoDrone(new DroneCargaInanimada(codigo,custoFixo,autonomia,2,pesoMaximo,protecao));
                        }
                    }
                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });
        processarTransportesPendentesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ct.getTransportesPendentes().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum transporte pendente.");
                } else {
                    JOptionPane.showMessageDialog(null, ct.getTransportesPendentes());
                }

            }
        });

        mostrarTodosOsTransportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(ct.getTransportesPendentes().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Nenhum transporte pendente.");
                    } else {
                        JOptionPane.showMessageDialog(null, ct.gerarRelatorioTransportes());
                    }

            }
        });
        alterarASituaçãoDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaAlteraSituacao JAS = new JanelaAlteraSituacao();

            }
        });
    }
        public JPanel getPainel() {

        return Painel;
    }
    }
