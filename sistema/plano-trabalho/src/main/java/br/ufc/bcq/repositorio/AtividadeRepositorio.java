package br.ufc.bcq.repositorio;

import java.util.Date;
import java.util.List;

import br.ufc.bcq.model.Atividade;
import br.ufc.bcq.model.Usuario;

public interface AtividadeRepositorio extends GenericRepositorio<Atividade> {
	
	List<Atividade> getAtividadesByDiaAndUsuario(Date inicio, Date termino, Usuario usuario);

}
