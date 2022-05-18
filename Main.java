import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    /*
     * Leia o nome, nota 1, nota 2, nota 3, de alunos e imprima o nome as notas, a
     * media de cada aluno bem como,
     * a media da turma de cada nota e a madia global das notas da turma e o total
     * de alunos com media maior ou igual
     * a 7 e o total com nota menor que 7
     */
    public static Turma turma = new Turma();
    public static JanelaPrincipal janela;

    public static void main(String[] args) {

        JSONParser arquivoJson = new JSONParser();

        try(FileReader arquivo = new FileReader("alunos.json")){
            JSONArray alunosJson = (JSONArray) arquivoJson.parse(arquivo);
            new LerJson(alunosJson);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        turma.calcularMedias();


        janela= new JanelaPrincipal();


    }
}