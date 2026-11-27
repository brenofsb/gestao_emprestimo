package usuarios;

import java.time.LocalDate;
import excessoes.CentroRecursosException;

public abstract class Usuario {
    private final String nome;
    private final String matricula;
    private boolean situacaoCadastral;
    private LocalDate dataUltimaAtualizacao;

    public Usuario(String nome, String matricula) throws CentroRecursosException {
        if(nome == null){
            throw new CentroRecursosException("O nome do usuário não pode ser vazio");
        }
        if(matricula == null){
            throw new CentroRecursosException("A matrícula do usuário não pode ser vazia");
        }
        this.nome = nome;
        this.matricula = matricula;
        this.situacaoCadastral = true;
        this.dataUltimaAtualizacao = LocalDate.now();

    }
    public abstract int getLimiteEmprestimo();

    public void alterarSituacao() {
        this.situacaoCadastral = !this.situacaoCadastral;
        this.dataUltimaAtualizacao = LocalDate.now();
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public boolean isSituacaoCadastral() {
        return situacaoCadastral;
    }

    public LocalDate getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }


}
