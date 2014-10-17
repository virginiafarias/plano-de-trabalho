package br.ufc.bcq.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.bcq.model.Atividade;
import br.ufc.bcq.model.Usuario;
import br.ufc.bcq.repositorio.AtividadeRepositorio;
import br.ufc.bcq.repositorio.UsuarioRepositorio;
import br.ufc.bcq.service.AtividadeService;

@Named
public class AtividadeServiceImpl implements AtividadeService {
	
	@Inject
	private AtividadeRepositorio atividadeRepositorio;
	
	@Inject
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public List<Atividade> getAtividadesByDiaAndUsuario(Date inicio, Date termino) {
		return atividadeRepositorio.getAtividadesByDiaAndUsuario(inicio, termino, usuarioRepositorio.find(Usuario.class, 1));
	}

}
