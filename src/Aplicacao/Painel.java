package Aplicacao;

import Dados.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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

    public Painel() {
        ACMEAirDrones ACMEAirDrone = new ACMEAirDrones();
        CadastroTransporte ct = CadastroTransporte.getInstancia();
        CadastroDrone cd = CadastroDrone.getInstancia();

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
                JanelaRelatorio JR = new JanelaRelatorio();
            }
        });
        salvarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String nomeArquivo = JOptionPane.showInputDialog(null, "Digite o nome do arquivo para salvar os dados:", "Nome do arquivo", JOptionPane.PLAIN_MESSAGE);
                    if (nomeArquivo == null || nomeArquivo.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum nome foi digitado.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            File file = new File(nomeArquivo.concat(".txt"));
                            FileWriter fw = new FileWriter(file);
                            BufferedWriter bufferedWriter = new BufferedWriter(fw);

                            bufferedWriter.write(cd.gerarRelatorioDrones());
                            bufferedWriter.append(ct.gerarRelatorioTransportes());
                            bufferedWriter.close();

                            JOptionPane.showMessageDialog(null, "Arquivo Criado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                        } catch (IOException ei) {
                            JOptionPane.showMessageDialog(null, nomeArquivo, ei.getMessage(), JOptionPane.WARNING_MESSAGE);
                        }
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

                                    ct.addTransporte(new TransportePessoal(
                                            1, codigo, nome, descricao, peso,
                                            latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino,
                                            estado, qtdPessoas
                                    ));
                                } catch (IllegalArgumentException ex) {
                                    JOptionPane.showMessageDialog(null, "Erro ao processar transporte: " + ex.getMessage());
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
                } else {
                    boolean sucesso = ct.processaTransportesPendentes();
                    if (sucesso) {
                        JOptionPane.showMessageDialog(null, "Transportes pendentes alocados com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Sem drones disponíveis para o processamento.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        mostrarTodosOsTransportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroTransporte ct = CadastroTransporte.getInstancia();
                String relatorio = ct.gerarRelatorioTransportes();
                JTextArea textArea = new JTextArea(relatorio);
                JScrollPane scrollPane = new JScrollPane(textArea);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                scrollPane.setPreferredSize(new java.awt.Dimension(500, 500));
                JOptionPane.showMessageDialog(null, scrollPane, "Relatório de Transportes", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        alterarASituaçãoDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaAlteraSituacao JAS = new JanelaAlteraSituacao();
            }
        });
        realizarLeituraDeDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeArquivoBase = JOptionPane.showInputDialog(null, "Digite o nome do arquivo base (sem extensão):", "Leitura de Dados", JOptionPane.PLAIN_MESSAGE);
                if (nomeArquivoBase == null || nomeArquivoBase.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nome do arquivo não pode ser vazio.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String arquivoDrones = nomeArquivoBase + "-DRONES.CSV";
                String arquivoTransportes = nomeArquivoBase + "-TRANSPORTES.CSV";

                try {
                    // Processa drones
                    carregarDrones(arquivoDrones);

                    // Processa transportes
                    carregarTransportes(arquivoTransportes);

                    // Exibe os dados carregados
                   CadastroTransporte ct = CadastroTransporte.getInstancia();
                   String relatorio = "Dados carregados com sucesso:\n\n" + cd.gerarRelatorioDrones() + "\n" + ct.gerarRelatorioTransportes();
                   JTextArea textArea = new JTextArea(relatorio);
                   JScrollPane scrollPane = new JScrollPane(textArea);
                   textArea.setLineWrap(true);
                   textArea.setWrapStyleWord(true);
                   scrollPane.setPreferredSize(new java.awt.Dimension(500, 500));
                   JOptionPane.showMessageDialog(null, scrollPane, "Relatório de Transportes", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro durante a leitura dos dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void carregarDrones(String arquivo) {
                CadastroDrone sistema = CadastroDrone.getInstancia();
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        String[] dados = linha.split(";");
                        switch (dados[0]) {
                            case "1" -> sistema.addDrone(new DronePessoal(
                                    Integer.parseInt(dados[1]), Double.parseDouble(dados[2]), Double.parseDouble(dados[3]),
                                    1, Integer.parseInt(dados[4])));
                            case "2" -> sistema.addDrone(new DroneCargaInanimada(
                                    Integer.parseInt(dados[1]), Double.parseDouble(dados[2]), Double.parseDouble(dados[3]),
                                    2, Double.parseDouble(dados[4]), Boolean.parseBoolean(dados[5])));
                            case "3" -> sistema.addDrone(new DroneCargaViva(
                                    Integer.parseInt(dados[1]), Double.parseDouble(dados[2]), Double.parseDouble(dados[3]),
                                    3, Double.parseDouble(dados[4]), Boolean.parseBoolean(dados[5])));
                            //default -> JOptionPane.showMessageDialog(null, "Tipo de drone desconhecido: " + dados[0], "Aviso", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (IOException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar drones do arquivo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void carregarTransportes(String arquivo) {
                CadastroTransporte sistema = CadastroTransporte.getInstancia();
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        try {
                            String[] dados = linha.split(";");
                            switch (dados[0]) {
                                case "1" -> sistema.addTransporte(new TransportePessoal(
                                        1, Integer.parseInt(dados[1]), dados[2], dados[3], Double.parseDouble(dados[4]),
                                        validarCoordenada(dados[5], "Latitude de origem"), validarCoordenada(dados[6], "Latitude de destino"),
                                        validarCoordenada(dados[7], "Longitude de origem"), validarCoordenada(dados[8], "Longitude de destino"),
                                        Estado.PENDENTE, Integer.parseInt(dados[9])));
                                case "2" -> sistema.addTransporte(new TransporteCargaInanimada(
                                        2, Integer.parseInt(dados[1]), dados[2], dados[3], Double.parseDouble(dados[4]),
                                        validarCoordenada(dados[5], "Latitude de origem"), validarCoordenada(dados[6], "Latitude de destino"),
                                        validarCoordenada(dados[7], "Longitude de origem"), validarCoordenada(dados[8], "Longitude de destino"),
                                        Estado.PENDENTE, Boolean.parseBoolean(dados[9])));
                                case "3" -> sistema.addTransporte(new TransporteCargaViva(
                                        2, Integer.parseInt(dados[1]), dados[2], dados[3], Double.parseDouble(dados[4]),
                                        validarCoordenada(dados[5], "Latitude de origem"), validarCoordenada(dados[6], "Latitude de destino"),
                                        validarCoordenada(dados[7], "Longitude de origem"), validarCoordenada(dados[8], "Longitude de destino"),
                                        Estado.PENDENTE, Double.parseDouble(dados[9]),Double.parseDouble(dados[10])));
                                }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Erro ao processar transporte: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar transportes do arquivo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private static double validarCoordenada(String valor, String nomeCampo) {
        valor = valor.trim();

        if (valor.chars().filter(ch -> ch == '.').count() > 1) {
            valor = valor.replaceFirst("\\.(?=.*\\.)", "");
        }
        if (valor.chars().filter(ch -> ch == '.').count() > 1) {
            throw new IllegalArgumentException(nomeCampo + " possui múltiplos pontos: " + valor);
        }
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