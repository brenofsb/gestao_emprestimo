package centro;
import equipamentos.*;
import excessoes.CentroRecursosException;
import usuarios.*;
import carga.*;
import java.util.ArrayList;
import java.util.List;

public class CentroRecursos {
    // TODO: manter a lista de equipamentos cadastrados.
    // TODO: manter a lista de usuarios cadastrados.
    // TODO: manter a lista de emprestimos registrados.
    private final List<BateriaPortatil> baterias = new ArrayList<>();

    public CentroRecursos(){

    }

    // TODO: cadastrar um usuario na lista de usuarios.
    // TODO: cadastrar um equipamento no catalogo.

    // TODO: localizar usuario pela matricula.
    // TODO: localizar equipamento pelo codigo de patrimonio.

    // TODO: buscar um emprestimo em aberto pela matricula e pelo codigo do equipamento.
    // TODO: contar quantos emprestimos em aberto pertencem ao usuario informado.

    // TODO: validar cadastro ativo, disponibilidade, preparacao e limite antes de emprestar.
    // TODO: criar o emprestimo, alterar a situacao do equipamento e adiciona-lo a lista.
    // TODO: registrar devolucao, validar data e carga, atualizar o equipamento e calcular atraso.
    // TODO: enviar equipamento para manutencao e encerrar manutencao.

    // Bateria portatil
    public void cadastBateria(BateriaPortatil bateria) throws CentroRecursosException{
        if (bateria == null){
            throw new CentroRecursosException("Bateria invalida");
        }

        for (int num = 0; num < baterias.size(); num++){
            BateriaPortatil cadastrada = baterias.get(num);

            if (cadastrada.cCodigo().equals(bateria.cCodigo())){
                throw new CentroRecursosException("Ja existe uma bateria com esse codigo");
            }
        }
        
        baterias.add(bateria);
    }

    public BateriaPortatil locaBateria(String codigo) throws CentroRecursosException{
        if (codigo == null || codigo.isBlank()){
            throw new CentroRecursosException("Codigo da bateria invalido");
        }

        for (int num = 0; num < baterias.size(); num++){
            BateriaPortatil bateria = baterias.get(num);

            if (codigo.equals(bateria.cCodigo())){
                return bateria;
            }
        }

        throw new CentroRecursosException("Bateria com codigo " + codigo + " nao encontrada");
    }

    public double cCargaBateria(String codigo) throws CentroRecursosException{
        return locaBateria(codigo).cCarga();
    }

    public int cTempoCargaBateria(String codigo) throws CentroRecursosException{
        return locaBateria(codigo).cTempoMin100();
    }

    public void chargeBateriaPorTempo(String codigo, int tempo) throws CentroRecursosException{
        locaBateria(codigo).altCargaTempo(tempo);
    }

    public void altCargaBateria(String codigo, double percentual) throws CentroRecursosException{
        locaBateria(codigo).altCargaPercent(percentual);
    }
}
