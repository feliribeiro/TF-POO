package Aplicacao;

import javax.swing.*;

public class JanelaAlteraSituacao extends JDialog {
    private formJanelaAlteraSituacao formJanelaAlteraSituacao;

    public JanelaAlteraSituacao() {
        super();
        formJanelaAlteraSituacao formJanelaAlteraSituacao = new formJanelaAlteraSituacao(this);
        this.setContentPane(formJanelaAlteraSituacao.getPainel());
        this.setTitle("Alterar Situação");
        this.pack();
        this.setSize(600,300);
        this.setModal(true);
        this.setVisible(true);
    }
}
