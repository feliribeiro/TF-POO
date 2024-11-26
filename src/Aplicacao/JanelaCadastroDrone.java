package Aplicacao;

import javax.swing.*;

public class JanelaCadastroDrone extends JDialog {
    private formJanelaCadastroDrone formJanelaCadastroDrone;

    public JanelaCadastroDrone() {
        super();
        formJanelaCadastroDrone formJanelaCadastroDrone = new formJanelaCadastroDrone(this);
        this.setContentPane(formJanelaCadastroDrone.getPainel());
        this.setTitle("Cadastro de Drone");
        this.pack();
        this.setSize(800,400);
        this.setModal(true);
        this.setVisible(true);


    }
}

