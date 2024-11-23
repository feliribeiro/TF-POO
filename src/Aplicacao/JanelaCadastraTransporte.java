package Aplicacao;

import javax.swing.*;

public class JanelaCadastraTransporte extends JDialog {
    private formJanelaCadastroDrone formJanelaCadastroDrone;

    public JanelaCadastraTransporte()  {
        super();
        formJanelaTransportes formJanelaTransportes = new formJanelaTransportes(this);
        this.setContentPane(formJanelaTransportes.getPainel());
        this.setTitle("Cadastro de Transporte");
        this.pack();
        this.setSize(800,400);
        this.setModal(true);
        this.setVisible(true);
    }
}

