package br.ufc.bcq.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;

import br.ufc.bcq.model.enumerator.Periodicidade;
import br.ufc.bcq.model.enumerator.Status;

@Entity
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany(mappedBy = "atividades")
	@JsonBackReference
	private List<Usuario> usuarios;

	@OneToMany(mappedBy = "atividade")
	private List<Documento> documentos;

	@ManyToMany
	private List<Label> labels;

	private String descricao;

	@Temporal(TemporalType.DATE)
	private Date inicio;

	@Temporal(TemporalType.DATE)
	private Date termino;

	private String observacoes;

	private String codigo;

	@Enumerated(EnumType.STRING)
	private Periodicidade periodicidade;

	@Enumerated(EnumType.STRING)
	private Status status;

	private Integer dia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Periodicidade getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(Periodicidade periodicidade) {
		this.periodicidade = periodicidade;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	@Override
	public String toString() {
		return "Atividade [id=" + id + ", descricao=" + descricao + ", inicio="
				+ inicio + ", termino=" + termino + ", observacoes="
				+ observacoes + ", codigo=" + codigo + ", periodicidade="
				+ periodicidade + ", status=" + status + ", dia=" + dia + "]";
	}

}