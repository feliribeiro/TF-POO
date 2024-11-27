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
        this.setSize(700,600);
        this.setModal(true);
        this.setVisible(true);
    }
}

