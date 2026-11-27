package equipamentos;

import excessoes.CentroRecursosException;

public abstract class Equipamento {
    private final double Patrimonio;
    private final String nome;
    private final String marca;
    private final String modelo;
    protected SITUACAO Situacao = SITUACAO.DISPONIVEL;

    public Equipamento(double patrimonio, String nome, String marca, String modelo) {
        Patrimonio = patrimonio;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
    }

    public void retirarParaEmprestimo() throws CentroRecursosException {
        if (this.Situacao == SITUACAO.EM_MANUTENCAO) {
            throw new CentroRecursosException("O objeto está em manutenção");
        }
        if (this.Situacao == SITUACAO.EMPRESTADO) {
            throw new CentroRecursosException("O objeto já esta emprestado");
        }
        conferirCondicoesEmprestimo();
        this.Situacao = SITUACAO.EMPRESTADO;
    }

    public void retirarParaManutencao() throws CentroRecursosException {
        if (this.Situacao == SITUACAO.EM_MANUTENCAO) {
            throw new CentroRecursosException("ERRO: o objeto já está em manutenção");
        }
        if (this.Situacao == SITUACAO.EMPRESTADO) {
            throw new CentroRecursosException("ERRO: o objeto está emprestado");
        }
        this.Situacao = SITUACAO.EM_MANUTENCAO;
    }

    public void devolver(boolean precisaReparo) throws CentroRecursosException {
        if (this.Situacao != SITUACAO.EMPRESTADO) {
            throw new CentroRecursosException("Erro: O objeto nao esta Emprestado");
        }
        if (precisaReparo) {
            this.Situacao = SITUACAO.EM_MANUTENCAO;
        } else {
            this.Situacao = SITUACAO.DISPONIVEL;
        }
    }

    public void encerrarManutencao() throws CentroRecursosException {
        if (this.Situacao != SITUACAO.EM_MANUTENCAO) {
            throw new CentroRecursosException("O objeto nao está em manutenção");
        }
        this.Situacao = SITUACAO.DISPONIVEL;
    }

    public abstract void conferirCondicoesEmprestimo() throws CentroRecursosException;

    public abstract int getPrazo();

    public double getPatrimonio() {
        return Patrimonio;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public SITUACAO getSituacao() {
        return Situacao;
    }

}

