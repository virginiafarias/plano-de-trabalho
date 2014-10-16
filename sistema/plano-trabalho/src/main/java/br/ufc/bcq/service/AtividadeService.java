package br.ufc.bcq.service;

import java.util.Date;
import java.util.List;

import br.ufc.bcq.model.Atividade;

public interface AtividadeService {
	
	List<Atividade> getAtividadesByDiaAndUsuario(Date inicio, Date termino);

}
