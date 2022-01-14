import java.util.Arrays;
import java.util.List;
public class FuncionarioProxy implements IFunc{
    private Funcionario funcionario;
    private Integer codigo;

    public FuncionarioProxy(Integer codigo) {
        this.codigo = codigo;
    }

    //qualquer gerente pode obter os dados pessoais de um funcionario, de qualquer setor
    @Override
    public List<String> obterDadosPessoais() {
        if (this.funcionario == null) {
            this.funcionario = new Funcionario(this.codigo);
        }
        return this.funcionario.obterDadosPessoais();
    }

    //apenas o gerente daquele setor especifico pode acessar o salario de um funcionario
    @Override
    public float obterSalario(Gerente gerente) {
        if (this.funcionario == null) {
            this.funcionario = new Funcionario(this.codigo);
        }

        if (!gerente.getSetor().equals(this.funcionario.obterSetor())) {
            throw new IllegalArgumentException("Gerente não autorizado -> setores diferentes");
        }

        return this.funcionario.obterSalario(gerente);
    }

    @Override
    public String obterSetor() {
        return this.funcionario.obterSetor();
    }
}