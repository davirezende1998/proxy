import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLOutput;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
class FuncionarioProxyTest {
    //povoando o banco de dados
    @BeforeEach
    void setUp() {
        Database.addFuncionario(new Funcionario(1, "Davi", "Financeiro", "Tokyo", 5000.0f));
        Database.addFuncionario(new Funcionario(2, "Laura", "RH", "Londres", 4000.0f));
    }

    @Test
    void deveRetornarDadosPessoaisFuncionario() {
        FuncionarioProxy funcionario1 = new FuncionarioProxy(1);
        FuncionarioProxy funcionario2 = new FuncionarioProxy(2);
        assertEquals(Arrays.asList("Davi", "Tokyo"), funcionario1.obterDadosPessoais());
        assertEquals(Arrays.asList("Laura", "Londres"), funcionario2.obterDadosPessoais());
    }

    @Test
    void deveRetonarSalarioFuncionario() {
        Gerente gerente = new Gerente("Sergio", "Financeiro");
        FuncionarioProxy funcionario = new FuncionarioProxy(1);
        assertEquals(5000.0f, funcionario.obterSalario(gerente));
    }

    @Test
    void deveRetonarExcecaoGerenteNaoAutorizado() {
        try {
            Gerente gerente = new Gerente("Marcos", "RH");
            FuncionarioProxy funcionario = new FuncionarioProxy(1);
            funcionario.obterSalario(gerente);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Gerente não autorizado -> setores diferentes", e.getMessage());
        }
    }
}