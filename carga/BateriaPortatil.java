package carga;

import excessoes.CentroRecursosException;

public class BateriaPortatil implements Carregavel {
    private final String codigo;
    private double carga;

    public BateriaPortatil(String codigo, double carga) throws CentroRecursosException{
        if (codigo == null || codigo.isBlank()){
            throw new CentroRecursosException("O codigo da bateria nao pode ser vazio");
        }

        if (Double.isNaN(carga) || carga < 0 || carga > 100){
            throw new CentroRecursosException("A carga inicial deve ser entre 0 e 100 por cento");
        }
        
        this.codigo = codigo;
        this.carga = carga;
    }

    public String cCodigo(){
        return codigo;
    }
    
    @Override 
    public double cCarga(){
        return carga;
    }

    @Override 
    public void altCargaTempo(int t) throws CentroRecursosException{
        if (t <= 0){
            throw new CentroRecursosException("O tempo deve ser positivo");
        }

        int intervalo = t / 2;
        double acrescimo = intervalo * 5;

        carga += acrescimo;

        if (carga > 100){
            carga = 100;
        }
    }

    @Override 
    public void altCargaPercent(double p) throws CentroRecursosException{
        if (Double.isNaN(p) || p < 0 || p > 100 || p > carga){
            throw new CentroRecursosException("O percentual deve estar entre 0 e a carga atual");
        }

        carga = p;

        while (carga < 100) {
            altCargaTempo(2);
        }
    }

    @Override 
    public int cTempoMin100(){
        double cargaT = carga;
        int min = 0;

        while (cargaT < 100) {
            cargaT += 5;

            if (cargaT > 100){
                cargaT = 100;
            }

            min += 2;
        }

        return min;
    }
}
