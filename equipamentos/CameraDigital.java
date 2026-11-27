package equipamentos;

import carga.Carregavel;
import excessoes.CentroRecursosException;

public class CameraDigital extends Equipamento implements Carregavel {
    private double carga;
    private boolean cartaoInstalado;
    private static int prazo = 3;
    private static final int taxaDeCarga = 3;
    private static final int minimaPEmprestar = 60;

    public CameraDigital(double patrimonio, String nome, String marca, String modelo, double carga, boolean cartaoInstalado) throws CentroRecursosException {
        super(patrimonio, nome, marca, modelo);
        validacaoDeCarga(carga);
        this.carga = carga;
        this.cartaoInstalado = cartaoInstalado;
    }

    private void validacaoDeCarga(double carga) throws CentroRecursosException {
        if (carga < 0 || carga > 100) {
            throw new CentroRecursosException("carga fora do Limite(de 0 a 100)");
        }
    }
    public static int alterarPrazo(int novoPrazo)throws CentroRecursosException{
        if (novoPrazo <=0){
            throw new CentroRecursosException("adicione um novo prazo válido(Numeros inteiros e positivos");
        }
        prazo = novoPrazo;
        return prazo;
    }

    public static int consultarPrazo() {
        return prazo;
    }

    @Override
    public void conferirCondicoesEmprestimo() throws CentroRecursosException {
        if (carga < minimaPEmprestar) {
            throw new CentroRecursosException("a carga não é suficiente pra emprestar");
        }
        if (!cartaoInstalado) {
            throw new CentroRecursosException("O carão não esta intalado");
        }

    }

    @Override
    public int getPrazo() {
        return prazo;
    }

    @Override
    public void altCargaPercent(double p) throws CentroRecursosException {
        validacaoDeCarga(p);
        this.carga = p;
    }

    @Override
    public int cTempoMin100() {
        double faltam;
        faltam = 100 - carga;
        if (faltam == 0) {
            return 0;
        }
        double intervalos = Math.ceil(faltam / taxaDeCarga);
        int intervaloInteiro = (int) intervalos*2;
        return intervaloInteiro;
    }

    @Override
    public void altCargaTempo(int t) throws CentroRecursosException {
        if (t <= 0) {
            throw new CentroRecursosException("o tempo é invalido(adicione um valor positivo e inteiro)");
        }
        int ganho = (t / 2) * taxaDeCarga;
        carga += ganho;
        carga = Math.min(carga, 100);
    }

    @Override
    public double cCarga() {
        return carga;
    }
}
