package Aplicacao;

import Dados.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
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
                try {
                    ACMEAirDrone.salvarDados();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        carregarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String arquivo = JOptionPane.showInputDialog(null, "Digite o nome do Arquivo:");
                try {
                    File file = new File(arquivo);
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String csvDivisor = ";";
                    String line;

                    while ((line = bufferedReader.readLine()) != null) {
                        String[] palavra = line.split(csvDivisor);

                        switch (palavra[0]) {
                            case "1" -> {
                                int codigo = Integer.parseInt(palavra[1]);
                                double custoFixo = Double.parseDouble(palavra[2]);
                                double autonomia = Double.parseDouble(palavra[3]);
                                int qtdMaxima = Integer.parseInt(palavra[4]);
                                ACMEAirDrone.cadastrarNovoDrone(new DronePessoal(codigo, custoFixo, autonomia, 1, qtdMaxima));
                            }
                            case "2" -> {
                                int codigo = Integer.parseInt(palavra[1]);
                                double custoFixo = Double.parseDouble(palavra[2]);
                                double autonomia = Double.parseDouble(palavra[3]);
                                double pesoMaximo = Double.parseDouble(palavra[4]);
                                boolean protecao = Boolean.parseBoolean(palavra[5]);
                                ACMEAirDrone.cadastrarNovoDrone(new DroneCargaInanimada(codigo, custoFixo, autonomia, 2, pesoMaximo, protecao));
                            }
                            case "3" -> {
                                int codigo = Integer.parseInt(palavra[1]);
                                double custoFixo = Double.parseDouble(palavra[2]);
                                double autonomia = Double.parseDouble(palavra[3]);
                                double pesoMaximo = Double.parseDouble(palavra[4]);
                                boolean climatizacao = Boolean.parseBoolean(palavra[5]);
                                ACMEAirDrone.cadastrarNovoDrone(new DroneCargaViva(codigo, custoFixo, autonomia, 2, pesoMaximo, climatizacao));
                            }
                            case "4" -> {
                                try {
                                    int codigo = Integer.parseInt(palavra[1]);
                                    String nome = palavra[2];
                                    String descricao = palavra[3];
                                    double peso = Double.parseDouble(palavra[4]);
                                    double latitudeOrigem = validarCoordenada(palavra[5], "Latitude de origem");
                                    double latitudeDestino = validarCoordenada(palavra[6], "Latitude de destino");
                                    double longitudeOrigem = validarCoordenada(palavra[7], "Longitude de origem");
                                    double longitudeDestino = validarCoordenada(palavra[8], "Longitude de destino");
                                    Estado estado = Estado.ALOCADO;

                                    switch (palavra[9].toUpperCase()) {
                                        case "PENDENTE" -> estado = Estado.PENDENTE;
                                        case "TERMINADO" -> estado = Estado.TERMINADO;
                                        case "CANCELADO" -> estado = Estado.CANCELADO;
                                    }

                                    int qtdPessoas = Integer.parseInt(palavra[10]);

                                    ACMEAirDrone.cadastraTransporte(new TransportePessoal(
                                            1, codigo, nome, descricao, peso,
                                            latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino,
                                            estado, qtdPessoas
                                    ));
                                } catch (IllegalArgumentException ex) {
                                    System.out.println("Erro ao processar transporte: " + ex.getMessage());
                                }
                            }
                            case "5" -> {
                                int codigo = Integer.parseInt(palavra[1]);
                                String nome = palavra[2];
                                String descricao = palavra[3];
                                double peso = Double.parseDouble(palavra[4]);
                                double latitudeOrigem = validarCoordenada(palavra[5], "Latitude de origem");
                                double latitudeDestino = validarCoordenada(palavra[6], "Latitude de destino");
                                double longitudeOrigem = validarCoordenada(palavra[7], "Longitude de origem");
                                double longitudeDestino = validarCoordenada(palavra[8], "Longitude de destino");
                                Estado estado = Estado.ALOCADO;
                                if (palavra[9].equalsIgnoreCase("pendente")) {
                                    estado = Estado.PENDENTE;
                                }
                                if (palavra[9].equalsIgnoreCase("TERMINADO")) {
                                    estado = Estado.TERMINADO;
                                }
                                if (palavra[9].equalsIgnoreCase("CANCELADO")) {
                                    estado = Estado.CANCELADO;
                                }
                                boolean cargaPerigosa = Boolean.parseBoolean(palavra[10]);
                                ACMEAirDrone.cadastraTransporte(new TransporteCargaInanimada(2, codigo, nome, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, estado, cargaPerigosa));
                            }
                        }
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
                }
            }
        });

        processarTransportesPendentesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ct.getTransportesPendentes().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum transporte pendente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else if (ct.processaTransportesPendentes()) {
                    JOptionPane.showMessageDialog(null, "Transportes pendentes processados com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Sem drones disponíveis para o processamento.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        mostrarTodosOsTransportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ct.getTransportesPendentes().isEmpty()) {
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

    private static double validarCoordenada(String valor, String nomeCampo) {
        valor = valor.trim();  // Remove espaços extras

        // Verificar se a coordenada já está no formato correto (apenas um ponto decimal)
        if (valor.chars().filter(ch -> ch == '.').count() > 1) {
            // Se houver múltiplos pontos, tentamos corrigir removendo pontos extras
            valor = valor.replaceFirst("\\.(?=.*\\.)", ""); // Remove o primeiro ponto extra
        }

        // Validar se ainda há mais de um ponto após a correção
        if (valor.chars().filter(ch -> ch == '.').count() > 1) {
            throw new IllegalArgumentException(nomeCampo + " possui múltiplos pontos: " + valor);
        }

        // Tentar converter o valor para double
        try {
            return Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(nomeCampo + " inválido: " + valor);
        }
    }

    public JPanel getPainel() {
        return Painel;
    }
}