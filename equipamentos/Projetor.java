package equipamentos;

import excessoes.CentroRecursosException;

public class Projetor extends Equipamento {
    private boolean HDMI;
    private static int prazo = 2;

    public Projetor(double patrimonio, String nome, String marca, String modelo, boolean HDMI) {
        super(patrimonio, nome, marca, modelo);
        this.HDMI = HDMI;
    }

    public static int consultarPrazo() {
        return prazo;
    }

    public static void alterarPrazo(int novoPrazo) throws CentroRecursosException {
        if (novoPrazo <= 0) {
            throw new CentroRecursosException("adicione um novo prazo válido");
        }
        prazo = novoPrazo;
    }

    public boolean isHDMI() {
        return HDMI;
    }

    @Override
    public int getPrazo() {
        return prazo;
    }

    @Override
    public void conferirCondicoesEmprestimo() throws CentroRecursosException {
        if (!HDMI) {
            throw new CentroRecursosException("o HDMI não está disponível");
        }
    }

}
