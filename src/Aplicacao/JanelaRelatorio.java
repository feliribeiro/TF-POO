package Aplicacao;

import javax.swing.*;

public class JanelaRelatorio extends JDialog {
    private formJanelaRelatorio formJanelaRelatorio;

    public JanelaRelatorio() {
        super();
        formJanelaRelatorio formJanelaRelatorio = new formJanelaRelatorio(this);
        this.setContentPane(formJanelaRelatorio.getPainel());
        this.setTitle("Relatório");
        this.pack();
        this.setSize(800,400);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setVisible(true);
    }
}

