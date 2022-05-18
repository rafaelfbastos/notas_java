import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GravarJson {

    private List<Aluno> lista;

    public GravarJson(List<Aluno> lista) {
        this.lista = lista;
    }

    public void gravar() {
        JSONArray listaJson = new JSONArray();

        for (Aluno aluno : lista) {

            JSONObject alunoJson = new JSONObject();
            alunoJson.put("nome", aluno.getNome());
            alunoJson.put("nota 1", aluno.getNota1());
            alunoJson.put("nota 2", aluno.getNota2());
            alunoJson.put("nota 3", aluno.getNota3());
            alunoJson.put("media", aluno.getMedia());

            listaJson.add(alunoJson);
        }

        try (FileWriter writer = new FileWriter("alunos.json")) {
            writer.write(listaJson.toJSONString());

        } catch (IOException e) {
            System.err.print("Erro ao gravar arquivo");
        }
    }

}
