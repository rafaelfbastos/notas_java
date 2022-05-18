import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JanelaCadastro extends JFrame {

    private JButton botao;
    private JTextField nomeField, nota1Field, nota2Field, nota3Field;

    public JanelaCadastro(){
        super();
        this.setTitle("Cadastar Aluno");
        this.setSize(new Dimension(300,250));
        this.setLocation(400,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setResizable(false);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setPreferredSize(new Dimension(50,30));
        this.add(nomeLabel);
        nomeField = new JTextField();
        nomeField.setPreferredSize(new Dimension(200,25));
        this.add(nomeField);

        JLabel nota1Label = new JLabel("Nota 1:");
        nota1Label.setPreferredSize(new Dimension(50,30));
        this.add(nota1Label);
        nota1Field = new JTextField();
        nota1Field.setPreferredSize(new Dimension(200,25));
        this.add(nota1Field);

        JLabel nota2Label = new JLabel("Nota 2:");
        nota2Label.setPreferredSize(new Dimension(50,30));
        this.add(nota2Label);
        nota2Field = new JTextField();
        nota2Field.setPreferredSize(new Dimension(200,25));
        this.add(nota2Field);

        JLabel nota3Label = new JLabel("Nota 3:");
        nota3Label.setPreferredSize(new Dimension(50,30));
        this.add(nota3Label);
        nota3Field = new JTextField();
        nota3Field.setPreferredSize(new Dimension(200,25));
        this.add(nota3Field);
        this.configurarBotao();
        this.add(botao);

        this.setVisible(true);

    }
    public void configurarBotao(){
        botao = new JButton("Cadastrar");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String tnota1 = nota1Field.getText();
                String tnota2 = nota2Field.getText();
                String tnota3 = nota3Field.getText();
                if(nome.isEmpty() || tnota1.isEmpty() || tnota2.isEmpty() || tnota3.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Preencha todos os campos","Atenção",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    try {
                        float nota1 = Float.parseFloat(tnota1);
                        float nota2 = Float.parseFloat(tnota2);
                        float nota3 = Float.parseFloat(tnota3);
                        Aluno aluno = new Aluno(nome, nota1, nota2, nota3);
                        Main.turma.addAluno(aluno);
                        Main.turma.calcularMedias();
                        Main.janela.atualizar();
                        dispose();

                    }catch(NumberFormatException exception){
                        JOptionPane.showMessageDialog(null,"Digite uma nota válida","Atenção",JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        });
    }

}
