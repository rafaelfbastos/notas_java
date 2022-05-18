import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class LerJson {

    private JSONArray lista;

    LerJson(JSONArray alunos){

        alunos.forEach(obj->lerJson((JSONObject) obj));

    }

    public void lerJson(JSONObject object){
        String nome = (String) object.get("nome");
        float nota1 = Float.parseFloat(object.get("nota 1").toString());
        float nota2 = Float.parseFloat(object.get("nota 2").toString());
        float nota3 = Float.parseFloat(object.get("nota 3").toString());
        Aluno aluno = new Aluno(nome,nota1,nota2,nota3);
        Main.turma.addAluno(aluno);
    }
}
