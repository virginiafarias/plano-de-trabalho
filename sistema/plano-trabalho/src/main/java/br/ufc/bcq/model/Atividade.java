package br.ufc.bcq.model;

import java.util.Date;
import java.util.List;

import br.ufc.bcq.model.enumerator.Periodicidade;

public class Atividade {
	
	private Long id;
	private List<Usuario> usuarios;
	private List<Documento> documentos;

	private String descricao;
	private Date inicio;
	private Date termino;
	private String observacoes;
	private String codigo;
	private Periodicidade periodicidade;
	private int dia;
	
	

}