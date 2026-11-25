package carga;

import excessoes.CentroRecursosException;

public interface Carregavel {
    double cCarga();
    void altCargaTempo(int t) throws CentroRecursosException;
    void altCargaPercent(double p) throws CentroRecursosException;
    int cTempoMin100();
}
