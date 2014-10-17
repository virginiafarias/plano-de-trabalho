package br.ufc.bcq.repositorio.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import br.ufc.bcq.model.Atividade;
import br.ufc.bcq.model.Usuario;
import br.ufc.bcq.model.enumerator.QueryType;
import br.ufc.bcq.repositorio.AtividadeRepositorio;

@Named
public class AtividadeRespositorioImpl extends GenericRepositorioImpl<Atividade> implements AtividadeRepositorio {

	@Override
	public List<Atividade> getAtividadesByDiaAndUsuario(Date inicio, Date termino, Usuario usuario) {
		Map<String, Object> namedParams = new HashMap<String, Object>();
		namedParams.put("usuario", usuario.getId());
		namedParams.put("inicio", inicio);
		namedParams.put("termino", termino);
		return find(QueryType.JPQL, "select distinct a from Atividade a join a.usuarios u where u.id = :usuario and ((:inicio >= a.inicio and :inicio <= a.termino) or (:termino >= a.inicio and :inicio <= a.termino))", namedParams);
	}

}
