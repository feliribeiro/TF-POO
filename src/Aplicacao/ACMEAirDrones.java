package Aplicacao;



import Dados.*;

//import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ACMEAirDrones extends JFrame {

    private Painel form; // Criado no editor
    private CadastroDrone cadastroDrone;
    private CadastroTransporte cadastroTransporte;

    public ACMEAirDrones() {
        super();
        cadastroDrone = new CadastroDrone();
        cadastroTransporte = new CadastroTransporte();

    }

    public void executar() {
        form = new Painel();
        this.add(form.getPainel());
        this.setSize(530, 450);
        this.setTitle("ACMEAirDrones");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void cadastrarNovoDrone(Drone drone ) {
        cadastroDrone.addDrone(drone);
    }

    public void cadastraTransporte(Transporte transporte) {
        cadastroTransporte.addTransporte(transporte);
    }

    public void processaTransportesPendentes() {
        cadastroTransporte.getTransportesPendentes();
    }

    public void mostraRelatorioGeral() {
        JOptionPane.showMessageDialog(null, cadastroDrone.gerarRelatorioDrones() + "\n" +
                cadastroTransporte.gerarRelatorioTransportes());
    }

    public void salvarDados() {}

    public void carregarDados() {
        String nomeArquivoCarregaDados = JOptionPane.showInputDialog(null, "Digite o nome do arquivo","Nome do arquivo", JOptionPane.PLAIN_MESSAGE);
        if (nomeArquivoCarregaDados == null || nomeArquivoCarregaDados.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum nome foi digitado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try{
            Scanner in = new Scanner(new File(nomeArquivoCarregaDados));
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                String[] dados = linha.split(",");
                if (dados[0] == null || dados[0].trim().isEmpty())
                    throw new FileNotFoundException();
                if (dados.length == 5)
                    cadastroDrone.addDrone(new DronePessoal(Integer.parseInt(dados[1]),Double.parseDouble(dados[2]),Double.parseDouble(dados[3]),Integer.parseInt(dados[4])));
                if (dados.length == 6){
                    if (dados[0].equals("1.1"))
                        cadastroDrone.addDrone(new DroneCargaViva(Integer.parseInt(dados[1]),Double.parseDouble(dados[2]),Double.parseDouble(dados[3]),Integer.parseInt(dados[4]),Boolean.parseBoolean(dados[5])));
                    if (dados[0].equals("1.2"))
                        cadastroDrone.addDrone(new DroneCargaInanimada(Integer.parseInt(dados[1]),Double.parseDouble(dados[2]),Double.parseDouble(dados[3]),Integer.parseInt(dados[4]),Boolean.parseBoolean(dados[5])));
                    }
                }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo nao encontrado. " + e.getMessage());
        }
    }
}