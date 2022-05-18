import javax.swing.table.AbstractTableModel;
import java.util.List;

public class Tabela extends AbstractTableModel {
    private final String[] header ={"Nome", "Nota 1", "Nota 2", "Nota 3","Media" };
    private final List<Aluno> TabelaList;

    public Tabela(List<Aluno> turma) {
        TabelaList = turma;
    }

    @Override
    public int getRowCount() {
        if(TabelaList==null){
            return 0;
        }
        return TabelaList.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return TabelaList.get(rowIndex).getNome();
            case 1:
                return String.format("%.1f",TabelaList.get(rowIndex).getNota1());
            case 2:
                return String.format("%.1f",TabelaList.get(rowIndex).getNota2());
            case 3:
                return String.format("%.1f",TabelaList.get(rowIndex).getNota3());
            case 4:
                return String.format("%.1f",TabelaList.get(rowIndex).getMedia());
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int indice){
        return header[indice];
    }
}
