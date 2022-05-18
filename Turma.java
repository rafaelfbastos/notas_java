import java.util.ArrayList;
import java.util.List;

public class Turma {
    private List<Aluno> turma;
    private int nAprovados;
    private int nReprovados;
    private float mediaNota1;
    private float mediaNota2;
    private float mediaNota3;
    private float mediaGlobal;

    public Turma() {

        turma = new ArrayList<Aluno>();
    }

    public List<Aluno> getTurma() {
        return turma;
    }

    public void addAluno(Aluno aluno) {
        turma.add(aluno);
    }

    public void calcularMedias() {
        float media1 = 0, media2 = 0, media3 = 0, mediag = 0;
            nAprovados=0;
            nReprovados=0;

        for (Aluno aluno : turma) {
            media1 = media1 + aluno.getNota1();
            media2 = media2 + aluno.getNota2();
            media3 = media3 + aluno.getNota3();
            mediag = mediag + aluno.getMedia();
            if (aluno.getMedia() >= 7) {
                nAprovados++;
            } else {
                nReprovados++;
            }
        }
        mediaNota1 = media1 / turma.size();
        mediaNota2 = media2 / turma.size();
        mediaNota3 = media3 / turma.size();
        mediaGlobal = mediag / turma.size();

    }

    public int getnAprovados() {
        return nAprovados;
    }

    public int getnReprovados() {
        return nReprovados;
    }

    public float getMediaNota1() {
        return mediaNota1;
    }

    public float getMediaNota2() {
        return mediaNota2;
    }

    public float getMediaNota3() {
        return mediaNota3;
    }

    public float getMediaGlobal() {
        return mediaGlobal;
    }

}
