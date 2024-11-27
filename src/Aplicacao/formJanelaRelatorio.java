package Aplicacao;

import Dados.CadastroDrone;
import Dados.CadastroTransporte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formJanelaRelatorio {

    private JanelaRelatorio janelaRelatorio;
    private JPanel painel;
    private JTextArea textArea1;
    private JButton OKButton;
    private JScrollPane scroll;

    public formJanelaRelatorio(JanelaRelatorio janelaRelatorio) {
        this.janelaRelatorio = janelaRelatorio;

        textArea1 = new JTextArea();
        textArea1.setEditable(false);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);

        scroll = new JScrollPane(textArea1);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        painel = new JPanel(new BorderLayout());
        painel.add(scroll, BorderLayout.CENTER);

        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        OKButton = new JButton("OK");
        painelBotao.add(OKButton);
        painel.add(painelBotao, BorderLayout.SOUTH);

        CadastroTransporte cadastroTransporte = CadastroTransporte.getInstancia();
        CadastroDrone cadastroDrone = CadastroDrone.getInstancia();
        textArea1.setText(cadastroDrone.gerarRelatorioDrones() + "\n" + cadastroTransporte.gerarRelatorioTransportes());

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaRelatorio.setVisible(false);
            }
        });
    }

    public JPanel getPainel() {
        return painel;
    }
}