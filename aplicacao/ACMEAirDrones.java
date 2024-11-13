import javax.swing.*;

public class ACMEAirDrones extends JFrame {
    private Painel form; // Criado no editor
    public ACMEAirDrones() {
        super();
    }
    public void executar() {
        form = new Painel();
        this.add(form.getPainel());
        this.setSize(800, 800);
        this.setTitle("ACMEAirDrones");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
