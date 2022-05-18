public class Aluno {
    private String nome;
    private float nota1;
    private float nota2;
    private float nota3;
    private float media;

    public Aluno(String nome, float nota1, float nota2, float nota3) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        media = (nota1+nota2+nota3)/3;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }
    public String getNome(){
        return nome;
    }

    public float getMedia(){
        media = (nota1 + nota2 + nota3)/3;
        return media;
    }
    
    @Override
    public String toString() {
        String mensagem = String.format("Aluno: %s\nNota 1: %.1f\nNota 2: %.1f\nNota 3: %.1f\nMedia: %.1f\n",
                                        nome,nota1,nota2,nota3,media );
        return mensagem;
    }
}
