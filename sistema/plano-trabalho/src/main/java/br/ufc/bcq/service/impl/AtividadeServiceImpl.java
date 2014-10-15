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
	public List<Atividade> getAllAtividades() {
		return atividadeRepositorio.find(Atividade.class);
	}

	@Override
	public List<Atividade> getAtividadesDiarias(Date data) {
		return atividadeRepositorio.getAtividadesByDiaAndUsuario(new Date(), usuarioRepositorio.find(Usuario.class, 1));
	}

	@Override
	public List<Atividade> getAtividadesSemanais(Date data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atividade> getAtividadesMensais(Date data) {
		// TODO Auto-generated method stub
		return null;
	}

}
