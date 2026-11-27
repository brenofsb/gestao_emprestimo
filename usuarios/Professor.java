package usuarios;

import excessoes.CentroRecursosException;

public class Professor extends Usuario{
    private String departamento;
    private static int limiteEmprestimos = 3;

    public Professor(String nome, String matricula) throws CentroRecursosException {
        super(nome, matricula);
        this.departamento = "Departamento de Ensino e Extensão";
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) throws CentroRecursosException {
        if (departamento == null) {
            throw new CentroRecursosException("O departamento não pode ser vazio.");
        }
        this.departamento = departamento.trim();
    }

    @Override
    public int getLimiteEmprestimo() {
        return limiteEmprestimos;
    }

    public static int getLimiteAtual() {
        return limiteEmprestimos;
    }

    public static void alterarLimite(int novoLimite) throws CentroRecursosException {
        if (novoLimite <= limiteEmprestimos) {
            throw new CentroRecursosException("O novo limite deve ser um número inteiro maior que o limite atual (" + limiteEmprestimos + ").");
        }
        limiteEmprestimos = novoLimite;
    }
}
