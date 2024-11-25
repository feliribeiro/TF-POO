package Aplicacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formJanelaTransportes{
    private JanelaCadastraTransporte janelaCadastraTransporte;
    private JPanel Painel;
    private JButton button1;
    private JRadioButton radioButton1;

    public formJanelaTransportes(JanelaCadastraTransporte janelaCadastraTransporte) {
        this.janelaCadastraTransporte = janelaCadastraTransporte;

    }

    public JPanel getPainel() {
        return Painel;
    }
}
