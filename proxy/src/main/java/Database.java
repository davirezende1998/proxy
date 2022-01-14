import java.util.HashMap;
import java.util.Map;
public class Database {
    private static Map<Integer, Funcionario> funcionarios = new HashMap<>();

    public static Funcionario getFuncionario(Integer codigo) {
        return funcionarios.get(codigo);
    }

    public static void addFuncionario(Funcionario funcionario) {
        funcionarios.put(funcionario.getCodigo(), funcionario);
    }
}