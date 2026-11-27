package usuarios;

import excessoes.CentroRecursosException;

public class Estudante extends Usuario{
    private static int limiteEmprestimos = 2;

    public Estudante(String nome, String matricula) throws CentroRecursosException {
        super(nome, matricula);
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
