import java.util.Arrays;
import java.util.List;
public class Funcionario implements IFunc{
    private Integer codigo;
    private String nome;
    private String setor;
    private String cidade;
    private Float salario;

    public Funcionario(int codigo) {
        this.codigo = codigo;
        Funcionario registro = Database.getFuncionario(codigo);
        this.nome = registro.nome;
        this.setor = registro.setor;
        this.cidade = registro.cidade;
        this.salario = registro.salario;
    }

    public Funcionario(Integer codigo, String nome, String setor, String cidade, Float salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.setor = setor;
        this.cidade = cidade;
        this.salario = salario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.cidade);
    }

    @Override
    public float obterSalario(Gerente gerente) {
        return this.salario;
    }

    @Override
    public String obterSetor() {
        return this.setor;
    }
}