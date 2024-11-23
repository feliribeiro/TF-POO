package Aplicacao;

import javax.swing.*;

public class formJanelaTransportes{
    private JanelaCadastraTransporte janelaCadastraTransporte;
    private JPanel Painel;

    public formJanelaTransportes(JanelaCadastraTransporte janelaCadastraTransporte) {
        this.janelaCadastraTransporte = janelaCadastraTransporte;
    }

    public JPanel getPainel() {
        return Painel;
    }
}
