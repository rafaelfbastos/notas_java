import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame {

    private JPanel headerPanel, turmaPanel, botPanel;
    private JButton cadastrar, salvar;
    private JLabel media1, media2, media3, mediaG;

    public JanelaPrincipal(){
        super();
        this.setTitle("Notas dos Alunos de ciências da computação");
        this.setSize(new Dimension(600,400));
        this.setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        Tabela tabela = new Tabela(Main.turma.getTurma());
        JTable jtable = new JTable(tabela);
        this.add(new JScrollPane(jtable),BorderLayout.CENTER);
        configHeader();
        configBot();
        configTurmaPanel();
        this.add(headerPanel,BorderLayout.NORTH);
        this.add(botPanel,BorderLayout.SOUTH);
        this.add(turmaPanel,BorderLayout.EAST);
        this.setVisible(true);

    }

    public void configHeader(){
        headerPanel = new JPanel();
        JLabel header = new JLabel("Notas dos alunos de Ciência da Computação",JLabel.CENTER);
        header.setFont(new Font("Verdana",Font.BOLD,15));
        header.setPreferredSize(new Dimension(500,40));
        headerPanel.setLayout(new FlowLayout());
        headerPanel.add(header);
    }
    public void configBot(){
        botPanel = new JPanel();
        botPanel.setLayout(new FlowLayout());
        configSalvar();
        configCadastrar();
        botPanel.add(cadastrar);
        botPanel.add(salvar);


    }
    public void configSalvar(){
        salvar = new JButton("Salvar");
        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GravarJson salvar = new GravarJson(Main.turma.getTurma());
                salvar.gravar();
            }
        });

    }

    public void configCadastrar(){
        cadastrar = new JButton("Adicionar");
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JanelaCadastro();
                atualizar();
                Main.turma.calcularMedias();
            }
        });

    }
    public void configTurmaPanel(){
        turmaPanel = new JPanel();
        turmaPanel.setPreferredSize(new Dimension(200,500));
        turmaPanel.setLayout(new BoxLayout(turmaPanel,BoxLayout.Y_AXIS));
        TitledBorder infoTurma = BorderFactory.createTitledBorder("Rendimento da turma");
        turmaPanel.setBorder(infoTurma);
        turmaPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        media1 = new JLabel(String.format("Media nota 1 = %.1f", Main.turma.getMediaNota1()));
        media1.setAlignmentX(Component.CENTER_ALIGNMENT);
        turmaPanel.add(media1);
        turmaPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        media2 = new JLabel(String.format("Media nota 2 = %.1f", Main.turma.getMediaNota2()));
        media2.setAlignmentX(Component.CENTER_ALIGNMENT);
        turmaPanel.add(media2);
        turmaPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        media3 = new JLabel(String.format("Media nota 3 = %.1f", Main.turma.getMediaNota3()));
        media3.setAlignmentX(Component.CENTER_ALIGNMENT);
        turmaPanel.add(media3);
        turmaPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mediaG = new JLabel(String.format("Media Global = %.1f", Main.turma.getMediaGlobal()));
        mediaG.setAlignmentX(Component.CENTER_ALIGNMENT);
        turmaPanel.add(mediaG);

    }

    public void atualizar(){
        SwingUtilities.updateComponentTreeUI(this);
        mediaG.setText(String.format("Media Global = %.1f", Main.turma.getMediaGlobal()));
        media1.setText(String.format("Media nota 1 = %.1f", Main.turma.getMediaNota1()));
        media2.setText(String.format("Media nota 2 = %.1f", Main.turma.getMediaNota2()));
        media3.setText(String.format("Media nota 3 = %.1f", Main.turma.getMediaNota3()));

    }
}
