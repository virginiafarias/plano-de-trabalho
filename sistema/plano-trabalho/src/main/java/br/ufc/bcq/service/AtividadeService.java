package br.ufc.bcq.service;

import java.util.Date;
import java.util.List;

import br.ufc.bcq.model.Atividade;

public interface AtividadeService {
	
	List<Atividade> getAllAtividades();
	
	List<Atividade> getAtividadesDiarias(Date data);
	
	List<Atividade> getAtividadesSemanais(Date data);
	
	List<Atividade> getAtividadesMensais(Date data);

}
