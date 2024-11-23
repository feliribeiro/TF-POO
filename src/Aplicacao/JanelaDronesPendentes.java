package Aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Dados.CadastroDrone;

public class JanelaDronesPendentes extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton closeButton;
    private CadastroDrone cadastroDrone;

    public JanelaDronesPendentes() {
        this.cadastroDrone = cadastroDrone;

        setTitle("Drones Pendentes");
        setSize(400, 300);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        closeButton = new JButton("Fechar");
        closeButton.addActionListener(this);
        add(closeButton, BorderLayout.SOUTH);

        mostrarDronesPendentes();
    }

    private void mostrarDronesPendentes() {
        String dadosDrones = cadastroDrone.mostraDrones();
        textArea.setText(dadosDrones);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeButton) {
            dispose();
        }
    }
}